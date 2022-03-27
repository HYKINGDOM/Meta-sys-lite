package com.java.meta.sys.lite.common.exception.constant;

import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_ACCOUNT_LENGTH_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_ALREADY_EXISTS_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_EMAIL_FORMAT_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_EMAIL_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_NAME_FORMAT_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_NAME_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_PASSWORD_STRENGTH_EXCEPTION_INFO;

/**
 * 异常信息常量
 *
 * @author HY
 */
public enum ExceptionEnumConstant {

    /**
     * user 信息已经存在异常
     */
    USER_DATA_ALREADY_EXISTS_EXCEPTION("A00101", USER_DATA_ALREADY_EXISTS_EXCEPTION_INFO),

    /**
     * 用户账号不能为空
     */
    USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION("A00010", USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION_INFO),

    /**
     * 用户名不能为空
     */
    USER_DATA_NAME_IS_EMPTY_EXCEPTION("A00011", USER_DATA_NAME_IS_EMPTY_EXCEPTION_INFO),

    /**
     * 用户邮箱不能为空
     */
    USER_DATA_EMAIL_IS_EMPTY_EXCEPTION("A00012", USER_DATA_EMAIL_IS_EMPTY_EXCEPTION_INFO),

    /**
     * 用户密码不能为空
     */
    USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION("A00013", USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION_INFO),

    /**
     * 用户名长度异常
     */
    USER_DATA_NAME_FORMAT_EXCEPTION("A00101", USER_DATA_NAME_FORMAT_EXCEPTION_INFO),

    /**
     * user 邮箱长度或格式异常
     */
    USER_DATA_EMAIL_FORMAT_EXCEPTION("A00102", USER_DATA_EMAIL_FORMAT_EXCEPTION_INFO),

    /**
     * 用户账户长度或格式异常
     */
    USER_DATA_ACCOUNT_FORMAT_EXCEPTION("A00103", USER_DATA_ACCOUNT_LENGTH_EXCEPTION_INFO),

    /**
     * user 密码强度不够
     */
    USER_DATA_PASSWORD_STRENGTH_EXCEPTION("A00104", USER_DATA_PASSWORD_STRENGTH_EXCEPTION_INFO);

    /**
     * 错误码
     */
    private String exceptionCode;

    /**
     * 异常信息
     */
    private String exceptionMessage;


    ExceptionEnumConstant(String exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }


    @Override
    public String toString() {
        return "ExceptionEnumConstant{" +
                "exceptionCode='" + exceptionCode + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
