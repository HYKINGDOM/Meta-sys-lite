package com.java.meta.sys.lite.common.exception;

/**
 * @author HY
 */
public class AuthAccountException extends BaseException {

    public AuthAccountException(String module, String code, Object[] args, String message) {
        super(module, code, args, message);
    }

    public AuthAccountException(String module, String code, Object[] args) {
        super(module, code, args);
    }

    public AuthAccountException(String code, String message) {
        super(code, message);
    }

    public AuthAccountException(String code, Object[] args) {
        super(code, args);
    }

    public AuthAccountException(String message) {
        super(message);
    }
}
