package com.java.meta.sys.lite.common.exception.user;

import com.java.meta.sys.lite.common.exception.BaseException;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;

/**
 * @author HY
 */
public class InvalidUserException extends BaseException {

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(ExceptionEnumConstant exceptionEnumConstant) {
        super(exceptionEnumConstant.getExceptionCode(), exceptionEnumConstant.getExceptionMessage());
    }

    public InvalidUserException(String message, String defaultMessage) {
        super(message, defaultMessage);
    }
}
