package com.java.meta.sys.lite.domain.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysRolePo;

public interface SysRoleRepository extends IService<SysRolePo> {

    SysRole saveOrUpdateSysRole(SysRole sysRole);
}
