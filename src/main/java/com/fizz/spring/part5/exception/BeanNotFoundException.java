package com.fizz.spring.part5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 找不到实体类异常(重定义映射为404)
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Bean Not Found")
public class BeanNotFoundException extends RuntimeException {



}
