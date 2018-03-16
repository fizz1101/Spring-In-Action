package com.fizz.spring.part5.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BeanNotFoundException.class)
    public String handleBeanNotFound() {
        //TODO 自己处理异常
        System.out.println("捕获到异常");
        return "";
    }

}
