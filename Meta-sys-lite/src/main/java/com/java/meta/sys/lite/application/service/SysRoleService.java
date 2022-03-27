package com.java.meta.sys.lite.application.service;

import com.java.meta.sys.lite.domain.model.domain.SysRole;

public interface SysRoleService {

    SysRole saveSysRole(SysRole sysRole);

    SysRole saveOrUpdateRole(SysRole sysRole);
}
