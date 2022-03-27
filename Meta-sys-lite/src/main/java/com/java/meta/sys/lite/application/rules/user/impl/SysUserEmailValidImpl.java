package com.java.meta.sys.lite.application.rules.user.impl;

import cn.hutool.core.util.StrUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.application.rules.user.SysUserEmailValid;
import org.springframework.stereotype.Service;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.*;
import static com.java.meta.sys.lite.common.utils.RegexUtils.validEmailAddressByRegex;

/**
 * @author HY
 */
@Service
public class SysUserEmailValidImpl implements SysUserEmailValid {

    @Override
    public void sysUserEmailIsEmpty(String userEmail) {
        if (StrUtil.isBlank(userEmail)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_EMAIL_IS_EMPTY_EXCEPTION);
        }
    }

    @Override
    public void sysUserEmailLengthValid(String userEmail) {
        int length = StrUtil.length(userEmail);
        if (length < MIN_USER_EMAIL_LENGTH || length > MAX_USER_EMAIL_LENGTH) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_EMAIL_FORMAT_EXCEPTION);
        }
    }

    @Override
    public void sysUserEmailFormatValid(String userEmail) {
        if (validEmailAddressByRegex(userEmail)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_EMAIL_FORMAT_EXCEPTION);
        }
    }
}
