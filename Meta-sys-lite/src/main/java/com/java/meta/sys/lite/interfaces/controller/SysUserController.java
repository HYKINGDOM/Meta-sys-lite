package com.java.meta.sys.lite.interfaces.controller;

import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import com.java.meta.sys.lite.domain.model.vo.SysUserPwVo;
import com.java.meta.sys.lite.domain.model.vo.SysUserVo;
import com.java.meta.sys.lite.application.service.SysUserDOService;
import com.java.meta.sys.lite.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.java.meta.sys.lite.common.constant.user.ReturnSuccessMessageConstant.*;

/**
 * @author HY
 */
@AllArgsConstructor
@RestController
@RequestMapping("/sys_user")
public class SysUserController {

    private final SysUserDOService sysUserDOService;

    private List<AccountService> accountServiceList;


    @GetMapping("/get-user/{accountType}")
    public SyncResult getSysUser(@PathVariable String accountType) {
        String accountId = accountServiceList
                .stream()
                .filter(e -> e.isAccountType(accountType))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getAccountName("test");
        return SyncResult.success(accountId);
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
