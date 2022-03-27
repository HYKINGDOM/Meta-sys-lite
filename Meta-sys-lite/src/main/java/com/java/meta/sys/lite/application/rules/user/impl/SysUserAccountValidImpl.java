package com.java.meta.sys.lite.application.rules.user.impl;

import cn.hutool.core.util.StrUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.application.rules.user.SysUserAccountValid;
import org.springframework.stereotype.Service;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MAX_USER_ACCOUNT_LENGTH;
import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MIN_USER_ACCOUNT_LENGTH;

/**
 * @author HY
 */
@Service
public class SysUserAccountValidImpl implements SysUserAccountValid {

    @Override
    public void sysUserAccountIsEmpty(String userAccount) {
        if (StrUtil.isBlank(userAccount)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION);
        }
    }

    @Override
    public void sysUserAccountLengthValid(String userAccount) {
        int length = StrUtil.length(userAccount);
        if (length < MIN_USER_ACCOUNT_LENGTH || length > MAX_USER_ACCOUNT_LENGTH) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_ACCOUNT_FORMAT_EXCEPTION);
        }
    }
}
