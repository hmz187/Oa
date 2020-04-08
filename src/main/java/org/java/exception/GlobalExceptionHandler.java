package org.java.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request,Exception ex){
        //获得异常原因
        String msg = ex.getMessage();
        //存储异常原因
        request.setAttribute("err",msg);
        //跳转到错误页面
        return "/err";
    }
}
