package com.java.meta.sys.lite.interfaces.controller;


import com.java.meta.sys.lite.application.service.SysRoleService;
import com.java.meta.sys.lite.common.utils.RanDomUtils;
import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.infrastructure.repository.db.convertor.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author HY
 */
@RestController
@RequestMapping("/sys_role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    private SysRole buildSysRole() {
        return SysRole.builder().roleId(123456).roleName(RanDomUtils.randomAlphabetic(5)).parentRoleId(1).roleStatus(1).build();
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