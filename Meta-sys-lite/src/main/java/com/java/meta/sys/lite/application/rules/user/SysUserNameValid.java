package com.java.meta.sys.lite.application.rules.user;

public interface SysUserNameValid {

    /**
     * userName 为空校验
     *
     * @param userName
     */
    void sysUserNameIsEmpty(String userName);

    /**
     * userName 长度校验
     *
     * @param userName
     */
    void sysUserNameLengthValid(String userName);
}
