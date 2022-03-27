package com.java.meta.sys.lite.application.rules.user;

/**
 * @author HY
 */
public interface SysUserAccountValid {

    /**
     * userAccount 为空校验
     * @param userAccount
     */
    void sysUserAccountIsEmpty(String userAccount);

    /**
     * userAccount 长度校验
     * @param userAccount
     */
    void sysUserAccountLengthValid(String userAccount);
}
