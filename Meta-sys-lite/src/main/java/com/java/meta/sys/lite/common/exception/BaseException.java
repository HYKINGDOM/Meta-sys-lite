package com.java.meta.sys.lite.common.exception;

import java.util.Arrays;

/**
 * @author HY
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * module
     */
    private String module;

    /**
     * error code
     */
    private String code;

    /**
     * parameters
     */
    private Object[] args;

    /**
     * error message
     */
    private String message;

    public BaseException(String module, String code, Object[] args, String message) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.message = message;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String code, String message) {
        this(null, code, null, message);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String message) {
        this(null, null, null, message);
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" + "module='" + module + '\'' + ", message='" + getMessage() + '\'' + '}';
    }

    public String logAllException() {
        return this.getClass() + "{" +
                "module='" + module + '\'' +
                ", message='" + getMessage() + '\'' +
                ", code='" + getCode() + '\'' +
                ", args='" + Arrays.toString(Arrays.stream(getArgs()).toArray()) + '}';
    }
}
