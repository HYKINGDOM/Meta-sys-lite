package com.java.meta.sys.lite.application.rules.user;

/**
 * 密码校验方法
 * @author HY
 */
public interface SysUserPasswordValid {

    /**
     * 用户密码为空校验
     * @param userPassword
     */
    void sysUserPasswordIsEmpty(String userPassword);

    /**
     * 密码长度校验
     * @param userPassword
     */
    void sysUserPasswordLengthValid(String userPassword);

    /**
     * 密码格式校验
     * @param userPassword
     */
    void sysUserPasswordFormatValid(String userPassword);
}
