package com.example.labdemo.result;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handException(RuntimeException e){
        return new ModelAndView("403error");
    }
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ResultResponse baseExceptionHandler(HttpServletRequest req, BaseException e){
        return ResultResponse.error(e.getErrorCode(),e.getErrorMsg());
    }
}

