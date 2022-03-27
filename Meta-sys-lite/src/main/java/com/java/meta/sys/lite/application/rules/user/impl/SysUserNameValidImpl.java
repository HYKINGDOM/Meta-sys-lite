package com.java.meta.sys.lite.application.rules.user.impl;

import cn.hutool.core.util.StrUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.application.rules.user.SysUserNameValid;
import org.springframework.stereotype.Service;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.*;

/**
 * @author HY
 */
@Service
public class SysUserNameValidImpl implements SysUserNameValid {

    @Override
    public void sysUserNameIsEmpty(String userName) {
        if (StrUtil.isBlank(userName)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_NAME_IS_EMPTY_EXCEPTION);
        }
    }

    @Override
    public void sysUserNameLengthValid(String userName) {
        int length = StrUtil.length(userName);
        if (length < MIN_USER_NAME_LENGTH || length > MAX_USER_NAME_LENGTH) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_NAME_FORMAT_EXCEPTION);
        }
    }
}
