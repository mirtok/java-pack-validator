package com.pack.exception;

import com.pack.message.ReturnObject;
import com.pack.message.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private List<ObjectError> errorList = null;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ReturnObject MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        errorList = e.getBindingResult().getAllErrors();
        logger.info(errorList.toString());
        String message = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        logger.error(message);
        return ReturnUtils.errorResult(message,null);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ReturnObject BindExceptionHandler(BindException e) {
        errorList = e.getBindingResult().getAllErrors();
        String message = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        logger.error(message);
        return ReturnUtils.errorResult(message,null);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ReturnObject ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
        return ReturnUtils.errorResult(message,null);
    }


}
