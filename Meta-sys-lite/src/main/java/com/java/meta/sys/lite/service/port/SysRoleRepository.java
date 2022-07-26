package com.java.meta.sys.lite.service.port;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.meta.sys.lite.domain.model.domain.Role;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.RoleEntity;

public interface SysRoleRepository extends IService<RoleEntity> {

    Role saveOrUpdateSysRole(Role role);
}
