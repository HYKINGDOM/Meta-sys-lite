package com.java.meta.sys.lite.service;

import com.java.meta.sys.lite.domain.model.domain.Role;

public interface SysRoleService {

    Role saveSysRole(Role role);

    Role saveOrUpdateRole(Role role);
}
