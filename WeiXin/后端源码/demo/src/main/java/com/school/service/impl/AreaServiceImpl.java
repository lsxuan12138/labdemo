package com.school.service.impl;

import com.school.dao.AreaDao;
import com.school.entity.Area;
import com.school.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area findByAreaId(int areaId) {
        return areaDao.findByAreaId(areaId);
    }
    @Transactional
    @Override
    public int insertArea(Area area) {
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int result=areaDao.insertArea(area);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入取余信息失败失败"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("插入的值有空的");
        }
      /*  return areaDao.insertArea(area);*/
    }

    @Override
    public int updateArea(Area area) {
        return areaDao.updateArea(area);
    }

    @Override
    public int deleteArea(int areaId) {
        return areaDao.deleteArea(areaId);
    }
}
