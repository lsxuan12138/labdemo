<<<<<<< HEAD
package com.school.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    private Map<String,Object> excetionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("error",e.getMessage());
        return modelMap;
    }
}
=======
package com.school.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    private Map<String,Object> excetionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("error",e.getMessage());
        return modelMap;
    }
}
>>>>>>> a23d072 (add WinXin)
