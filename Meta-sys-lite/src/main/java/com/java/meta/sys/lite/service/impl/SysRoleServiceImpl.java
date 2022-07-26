package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.domain.model.domain.Role;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.RoleEntity;
import com.java.meta.sys.lite.service.SysRoleService;
import com.java.meta.sys.lite.service.port.SysRoleRepository;
import com.java.meta.sys.lite.infrastructure.repository.db.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author HY
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleRepository sysRoleRepository;

    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role saveSysRole(Role role) {
        return sysRoleRepository.saveOrUpdateSysRole(role);
    }

    @Override
    public Role saveOrUpdateRole(Role role) {
        RoleEntity roleEntity = roleEntityMapper.toRoleEntity(role);
        boolean saveOrUpdate = sysRoleRepository.saveOrUpdate(roleEntity);
        System.out.println("insertId" + saveOrUpdate);
        return null;
    }
}
