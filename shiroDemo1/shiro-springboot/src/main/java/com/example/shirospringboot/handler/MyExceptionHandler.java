package com.example.shirospringboot.handler;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    @ResponseBody
    public String authorizationException(){
        return "没权限o！";
    }
}
