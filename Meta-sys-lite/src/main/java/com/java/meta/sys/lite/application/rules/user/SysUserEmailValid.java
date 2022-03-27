package com.java.meta.sys.lite.application.rules.user;

public interface SysUserEmailValid {

    /**
     * 邮箱为空校验
     * @param userEmail
     */
    void sysUserEmailIsEmpty(String userEmail);

    /**
     * 邮箱长度校验
     * @param userEmail
     */
    void sysUserEmailLengthValid(String userEmail);

    /**
     * 邮箱格式校验
     * @param userEmail
     */
    void sysUserEmailFormatValid(String userEmail);
}
