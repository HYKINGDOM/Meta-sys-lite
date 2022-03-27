package com.java.meta.sys.lite;

import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import com.java.meta.sys.lite.domain.model.vo.SysUserPwVo;
import com.java.meta.sys.lite.domain.model.vo.SysUserVo;
import com.java.meta.sys.lite.application.service.SysUserDOService;
import org.springframework.web.bind.annotation.*;

import static com.java.meta.sys.lite.common.constant.user.ReturnSuccessMessageConstant.*;

/**
 * @author HY
 */
@RestController
@RequestMapping("/sys_user")
public class SysUserController {

    private final SysUserDOService sysUserDOService;


    public SysUserController(SysUserDOService sysUserDOService) {
        this.sysUserDOService = sysUserDOService;
    }

    @PostMapping("/create_user")
    public SyncResult createSysUser(@RequestBody SysUserPwVo sysUserPwVo) {
        sysUserDOService.createSysUserByVo(sysUserPwVo);
        return SyncResult.success(ADD_USER_SUCCESS_MESSAGE);
    }



    @DeleteMapping("/delete_user")
    public SyncResult deleteSysUser(@RequestBody SysUserVo sysUserVo) {
        sysUserDOService.deleteUser(sysUserVo);
        return SyncResult.success(DELETE_USER_SUCCESS_MESSAGE);
    }
}
