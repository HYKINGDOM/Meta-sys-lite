package com.java.meta.sys.lite.interfaces.controller;

import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserPwVo;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserVo;
import com.java.meta.sys.lite.service.SysUserDOService;
import com.java.meta.sys.lite.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.java.meta.sys.lite.common.constant.user.ReturnSuccessMessageConstant.*;

/**
 * @author HY
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class SysAccountController {

    private final SysUserDOService sysUserDOService;

    private final List<AccountService> accountServiceList;


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
    public SyncResult createSysAccount(@RequestBody SysUserPwVo sysUserPwVo) {
        sysUserDOService.createSysUserByVo(sysUserPwVo);
        return SyncResult.success(ADD_USER_SUCCESS_MESSAGE);
    }


    @DeleteMapping
    public SyncResult deleteSysAccount(@RequestBody SysUserVo sysUserVo) {
        sysUserDOService.deleteUser(sysUserVo);
        return SyncResult.success(DELETE_USER_SUCCESS_MESSAGE);
    }
}
