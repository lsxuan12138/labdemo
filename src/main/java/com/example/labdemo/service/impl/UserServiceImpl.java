package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Role;
import com.example.labdemo.domain.User;
import com.example.labdemo.dto.UserAddDto;
import com.example.labdemo.dto.UserChangeInfoDto;
import com.example.labdemo.mapper.RoleDao;
import com.example.labdemo.mapper.UserDao;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.security.LoginUser;
import com.example.labdemo.security.RedisCache;
import com.example.labdemo.service.UserService;
import com.example.labdemo.util.BCPEUtils;
import com.example.labdemo.util.JwtUtil;
import com.example.labdemo.vo.UserCtrlVo;
import com.example.labdemo.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-12 13:31
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Override
    public ResultResponse login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new BaseException(BaseExceptionEnum.LOGIN_ERROR);
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        if(Boolean.FALSE.equals(loginUser.getUser().getAlive())){
            throw new BaseException(BaseExceptionEnum.USER_HAS_NOT_ALIVE);
        }
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser,1, TimeUnit.HOURS);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResultResponse.success(map);
    }

    @Override
    public void adduser(UserAddDto userAddDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account",userAddDto.getUsername());
        if(userDao.selectOne(wrapper)!=null)throw new BaseException(BaseExceptionEnum.USER_INSERT_ERROR);
        userDao.insert(userAddDto.toUser());
    }

    @Override
    public ResultResponse logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+userid);
        return ResultResponse.success();
    }

    @Override
    public List<User> selectByRole(String roleName){
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("name",roleName);
        Role role = roleDao.selectOne(roleQueryWrapper);
        if (role == null) {
            throw new BaseException();
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_id",role.getId());
        userQueryWrapper.eq("is_alive",1);
        List<User> users = userDao.selectList(userQueryWrapper);
        if (users == null||users.isEmpty()) {
            throw new BaseException();
        }
        return users;
    }
    @Override
    public List<UserCtrlVo> selectAllUserVo(){
        return userDao.selectAllUserVo();
    }
    @Override
    public void activeUser(Long id){
        User user = userDao.selectById(id);
        if(user==null){
            throw new BaseException(BaseExceptionEnum.USER_NO_EXIST);
        }
        if(user.getAlive()){
            throw new BaseException(BaseExceptionEnum.USER_HAS_ALIVE);
        }
        user.setAlive(true);
        userDao.updateById(user);
    }
    @Override
    public UserInfoVo getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        return userDao.selectUserInfoById(userid);
    }

    @Override
    public void changeUserInfo(UserChangeInfoDto dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        User user = userDao.selectById(userid);
        if(!BCPEUtils.matches(dto.getOldPassword(),user.getPassword())){
            throw new BaseException(BaseExceptionEnum.PASSWORD_NOT_MATCH);
        }
        user.setName(dto.getUsername());
        user.setPassword(BCPEUtils.encode(dto.getPassword()));
        userDao.updateById(user);
        redisCache.deleteObject("login:"+userid);
    }
}
