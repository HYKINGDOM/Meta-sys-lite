package com.java.meta.sys.lite.application.rules.user.impl;

import cn.hutool.core.util.StrUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.application.rules.user.SysUserPasswordValid;
import org.springframework.stereotype.Service;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.*;
import static com.java.meta.sys.lite.common.utils.RegexUtils.validPasswordLengthAndStrength;

/**
 * @author HY
 */
@Service
public class SysUserPasswordValidImpl implements SysUserPasswordValid {

    @Override
    public void sysUserPasswordIsEmpty(String userPassword) {
        if (StrUtil.isBlank(userPassword)) {
            String exceptionMessage = ExceptionEnumConstant.USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION.getExceptionMessage();
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION);
        }
    }

    @Override
    public void sysUserPasswordLengthValid(String userPassword) {
        int length = StrUtil.length(userPassword);
        if (length < MIN_PASSWORD_LENGTH || length > MAX_PASSWORD_LENGTH) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_PASSWORD_STRENGTH_EXCEPTION);
        }
    }

    @Override
    public void sysUserPasswordFormatValid(String userPassword) {
        if (!validPasswordLengthAndStrength(userPassword)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_PASSWORD_STRENGTH_EXCEPTION);
        }
    }
}
