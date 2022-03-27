package com.java.meta.sys.lite.common.exception;

import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;

/**
 * 全局异常处理器
 *
 * @author HY
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({Exception.class})
    public SyncResult handleException(Exception exception) {
        log.error(exception.toString());
        return SyncResult.error(exception.getMessage());
    }


    @ExceptionHandler({MyBatisSystemException.class})
    public SyncResult handleMyBatisSystemException(MyBatisSystemException exception) {
        log.error(exception.toString());
        return SyncResult.error(exception.getMessage());
    }

    @ExceptionHandler({InvalidUserException.class})
    public SyncResult handleInvalidUserException(InvalidUserException exception) {
        log.error(exception.toString());
        return SyncResult.error(exception.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public SyncResult handleValidationException(ValidationException exception) {
        String errorCode = exception.getErrorCode();
        log.error(errorCode, exception.toString());
        return SyncResult.error(errorCode, exception.getMessage());
    }
}
