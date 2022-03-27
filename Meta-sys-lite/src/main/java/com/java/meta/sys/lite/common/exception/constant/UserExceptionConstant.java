package com.java.meta.sys.lite.common.exception.constant;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MAX_PASSWORD_LENGTH;
import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MIN_PASSWORD_LENGTH;

/**
 * @author HY
 */
public class UserExceptionConstant {

    public static final String USER_DATA_ALREADY_EXISTS_EXCEPTION_INFO = "用户已经存在";


    public static final String USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION_INFO = "用户账号不能为空";

    public static final String USER_DATA_ACCOUNT_LENGTH_EXCEPTION_INFO = "用户账号长度异常";


    public static final String USER_DATA_NAME_IS_EMPTY_EXCEPTION_INFO = "用户名不能为空";

    public static final String USER_DATA_NAME_FORMAT_EXCEPTION_INFO = "用户名长度异常";


    public static final String USER_DATA_EMAIL_IS_EMPTY_EXCEPTION_INFO = "用户邮箱不能为空";

    public static final String USER_DATA_EMAIL_FORMAT_EXCEPTION_INFO = "邮箱格式异常";

    public static final String USER_DATA_EMAIL_LENGTH_EXCEPTION_INFO = "邮箱长度异常";


    public static final String USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION_INFO = "用户密码不能为空";

    public static final String USER_DATA_PASSWORD_STRENGTH_EXCEPTION_INFO = "请设置密码长度为" + MIN_PASSWORD_LENGTH + "-" + MAX_PASSWORD_LENGTH + "和包含大小写和数字";


}
