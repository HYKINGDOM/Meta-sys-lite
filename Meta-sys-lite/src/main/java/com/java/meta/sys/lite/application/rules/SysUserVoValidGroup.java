package com.java.meta.sys.lite.application.rules;

import com.java.meta.sys.lite.domain.model.vo.SysUserPwVo;
import com.java.meta.sys.lite.domain.model.vo.SysUserVo;
import com.java.meta.sys.lite.application.rules.user.SysUserAccountValid;
import com.java.meta.sys.lite.application.rules.user.SysUserEmailValid;
import com.java.meta.sys.lite.application.rules.user.SysUserNameValid;
import com.java.meta.sys.lite.application.rules.user.SysUserPasswordValid;
import org.springframework.stereotype.Component;

/**
 * @author HY
 */
@Component
public class SysUserVoValidGroup {

    private final SysUserAccountValid sysUserAccountValid;

    private final SysUserNameValid sysUserNameValid;

    private final SysUserEmailValid sysUserEmailValid;

    private final SysUserPasswordValid sysUserPasswordValid;

    public SysUserVoValidGroup(SysUserAccountValid sysUserAccountValid, SysUserNameValid sysUserNameValid, SysUserEmailValid sysUserEmailValid, SysUserPasswordValid sysUserPasswordValid) {
        this.sysUserAccountValid = sysUserAccountValid;
        this.sysUserNameValid = sysUserNameValid;
        this.sysUserEmailValid = sysUserEmailValid;
        this.sysUserPasswordValid = sysUserPasswordValid;
    }

    public void createSysUserInfoValid(SysUserPwVo sysUserPwVo) {
        String userAccount = sysUserPwVo.getUserAccount();
        sysUserAccountValid.sysUserAccountIsEmpty(userAccount);
        sysUserAccountValid.sysUserAccountLengthValid(userAccount);

        String userName = sysUserPwVo.getUserName();
        sysUserNameValid.sysUserNameIsEmpty(userName);
        sysUserNameValid.sysUserNameLengthValid(userName);

        String userEmail = sysUserPwVo.getUserEmail();
        sysUserEmailValid.sysUserEmailIsEmpty(userEmail);
        sysUserEmailValid.sysUserEmailLengthValid(userEmail);
        sysUserEmailValid.sysUserEmailFormatValid(userEmail);

        String userPassword = sysUserPwVo.getUserPassword();
        sysUserPasswordValid.sysUserPasswordIsEmpty(userPassword);
        sysUserPasswordValid.sysUserPasswordLengthValid(userPassword);
        sysUserPasswordValid.sysUserPasswordFormatValid(userPassword);
    }

    public void deleteSysUserInfoValid(SysUserVo sysUserVo){
        String userAccount = sysUserVo.getUserAccount();
        sysUserAccountValid.sysUserAccountIsEmpty(userAccount);
        sysUserAccountValid.sysUserAccountLengthValid(userAccount);

        String userName = sysUserVo.getUserName();
        sysUserNameValid.sysUserNameIsEmpty(userName);
        sysUserNameValid.sysUserNameLengthValid(userName);

        String userEmail = sysUserVo.getUserEmail();
        sysUserEmailValid.sysUserEmailIsEmpty(userEmail);
        sysUserEmailValid.sysUserEmailLengthValid(userEmail);
        sysUserEmailValid.sysUserEmailFormatValid(userEmail);
    }
}
