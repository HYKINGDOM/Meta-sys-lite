package com.java.meta.sys.lite.application.service.serviceImpl;

import com.java.meta.sys.lite.application.service.SysRoleService;
import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.domain.repository.SysRoleRepository;
import com.java.meta.sys.lite.infrastructure.repository.db.convertor.SysRoleMapper;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysRolePo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author HY
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleRepository sysRoleRepository;

    private final SysRoleMapper sysRoleMapper;

    @Override
    public SysRole saveSysRole(SysRole sysRole) {
        return sysRoleRepository.saveOrUpdateSysRole(sysRole);
    }

    @Override
    public SysRole saveOrUpdateRole(SysRole sysRole) {
        SysRolePo sysRolePo = sysRoleMapper.toSysRolePo(sysRole);
        boolean saveOrUpdate = sysRoleRepository.saveOrUpdate(sysRolePo);
        System.out.println("insertId" + saveOrUpdate);
        return null;
    }
}
