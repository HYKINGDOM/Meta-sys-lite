package com.java.meta.sys.lite.domain.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MAX_PASSWORD_LENGTH;
import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.MIN_PASSWORD_LENGTH;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION_INFO;
import static com.java.meta.sys.lite.common.exception.constant.UserExceptionConstant.USER_DATA_PASSWORD_STRENGTH_EXCEPTION_INFO;

/**
 * @author HY
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class SysUserPwVo extends SysUserVo {

    @Size(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH, message = USER_DATA_PASSWORD_STRENGTH_EXCEPTION_INFO)
    @NotEmpty(message = USER_DATA_PASSWORD_IS_EMPTY_EXCEPTION_INFO)
    private String userPassword;

}
