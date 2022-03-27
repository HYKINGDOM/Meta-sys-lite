package com.java.meta.sys.lite.common.utils;

import java.util.regex.Pattern;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MAX_PASSWORD_LENGTH;
import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MIN_PASSWORD_LENGTH;

/**
 * 正则常量
 *
 * @author HY
 */
public class RegexUtils {


    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");


    public static final Pattern VALID_PASSWORD_LENGTH = Pattern.compile("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{" + MIN_PASSWORD_LENGTH + "," + MAX_PASSWORD_LENGTH + "}$");


    /**
     * 正则表达式校验邮箱地址
     *
     * @return true is no valid
     */
    public static boolean validEmailAddressByRegex(String emailAddress) {
        return !EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches();
    }

    /**
     * 正则表达式校验密码强度
     *
     * @return true is password not strength
     */
    public static boolean validPasswordLengthAndStrength(String passwordLength) {
        return VALID_PASSWORD_LENGTH.matcher(passwordLength).matches();
    }

}
