package com.java.meta.sys.lite.domain.model.vo;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.*;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_ACCOUNT_LENGTH_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_EMAIL_FORMAT_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_EMAIL_LENGTH_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_NAME_FORMAT_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_NAME_IS_EMPTY_EXCEPTION_INFO;

/**
 * @author HY
 */
@SuperBuilder
@Data
public class SysUserVo {

    private String userId;

    @Size(min = MIN_USER_ACCOUNT_LENGTH, max = MAX_USER_ACCOUNT_LENGTH, message = USER_DATA_ACCOUNT_LENGTH_EXCEPTION_INFO)
    @NotEmpty(message = USER_DATA_ACCOUNT_IS_EMPTY_EXCEPTION_INFO)
    private String userAccount;

    @Size(min = MIN_USER_NAME_LENGTH, max = MAX_USER_NAME_LENGTH, message = USER_DATA_NAME_FORMAT_EXCEPTION_INFO)
    @NotEmpty(message = USER_DATA_NAME_IS_EMPTY_EXCEPTION_INFO)
    private String userName;

    @Email(message = USER_DATA_EMAIL_FORMAT_EXCEPTION_INFO)
    @Size(min = MIN_USER_EMAIL_LENGTH, max = MAX_USER_EMAIL_LENGTH, message = USER_DATA_EMAIL_LENGTH_EXCEPTION_INFO)
    @NotEmpty
    private String userEmail;
}
