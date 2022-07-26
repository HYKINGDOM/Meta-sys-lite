package com.java.meta.sys.lite.infrastructure.repository.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.meta.sys.lite.domain.model.domain.Role;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.RoleEntity;
import com.java.meta.sys.lite.service.port.SysRoleRepository;
import com.java.meta.sys.lite.infrastructure.repository.db.mapper.RoleEntityMapper;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.SysRoleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author HY
 */
@RequiredArgsConstructor
@Component
public class SysRoleRepositoryImpl extends ServiceImpl<SysRoleDao, RoleEntity> implements SysRoleRepository {

    private final SysRoleDao sysRoleDao;

    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role saveOrUpdateSysRole(Role role) {
        RoleEntity roleEntity = roleEntityMapper.toRoleEntity(role);
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleEntity::getRoleId, roleEntity.getRoleId());
        RoleEntity selectOne = sysRoleDao.selectOne(queryWrapper);
        if (selectOne == null) {
            sysRoleDao.insert(roleEntity);
        } else {
            UpdateWrapper<RoleEntity> updateWrapper = new UpdateWrapper<>();
            LambdaUpdateWrapper<RoleEntity> sysRolePoLambdaUpdateWrapper = updateWrapper.lambda()
                    .eq(RoleEntity::getRoleId, selectOne.getRoleId())
                    .eq(RoleEntity::getId, selectOne.getId())
                    .eq(RoleEntity::getVersion, selectOne.getVersion())
                    .set(RoleEntity::getRoleName, roleEntity.getRoleName())
                    .set(RoleEntity::getParentRoleId, roleEntity.getParentRoleId())
                    .set(RoleEntity::getRoleStatus, roleEntity.getRoleStatus());
            sysRoleDao.update(selectOne, sysRolePoLambdaUpdateWrapper);
        }
        return role;
    }
}
