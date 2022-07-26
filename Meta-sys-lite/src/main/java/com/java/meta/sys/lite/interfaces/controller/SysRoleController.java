package com.java.meta.sys.lite.interfaces.controller;


import com.java.meta.sys.lite.domain.model.domain.Role;
import com.java.meta.sys.lite.service.SysRoleService;
import com.java.meta.sys.lite.common.utils.RanDomUtils;
import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author HY
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;


    private Role buildSysRole() {
        return Role.builder().roleId(123456).roleName(RanDomUtils.randomAlphabetic(5)).parentRoleId(1).roleStatus(1).build();
    }

    @PostMapping
    public SyncResult createRole() {
        sysRoleService.saveSysRole(buildSysRole());
        return SyncResult.success();
    }

    @GetMapping
    public SyncResult getRole() {
        sysRoleService.saveOrUpdateRole(buildSysRole());
        return SyncResult.success();
    }
}