package com.java.meta.sys.lite.infrastructure.repository.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.domain.repository.SysRoleRepository;
import com.java.meta.sys.lite.infrastructure.repository.db.convertor.SysRoleMapper;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.SysRoleDao;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysRolePo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author HY
 */
@RequiredArgsConstructor
@Component
public class SysRoleRepositoryImpl extends ServiceImpl<SysRoleDao, SysRolePo> implements SysRoleRepository {

    private final SysRoleDao sysRoleDao;

    private final SysRoleMapper sysRoleMapper;

    @Override
    public SysRole saveOrUpdateSysRole(SysRole sysRole) {
        SysRolePo sysRolePo = sysRoleMapper.toSysRolePo(sysRole);
        QueryWrapper<SysRolePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRolePo::getRoleId, sysRolePo.getRoleId());
        SysRolePo selectOne = sysRoleDao.selectOne(queryWrapper);
        if (selectOne == null) {
            sysRoleDao.insert(sysRolePo);
        } else {
            UpdateWrapper<SysRolePo> updateWrapper = new UpdateWrapper<>();
            LambdaUpdateWrapper<SysRolePo> sysRolePoLambdaUpdateWrapper = updateWrapper.lambda()
                    .eq(SysRolePo::getRoleId, selectOne.getRoleId())
                    .eq(SysRolePo::getId, selectOne.getId())
                    .eq(SysRolePo::getVersion, selectOne.getVersion())
                    .set(SysRolePo::getRoleName, sysRolePo.getRoleName())
                    .set(SysRolePo::getParentRoleId, sysRolePo.getParentRoleId())
                    .set(SysRolePo::getRoleStatus, sysRolePo.getRoleStatus());
            sysRoleDao.update(selectOne, sysRolePoLambdaUpdateWrapper);
        }
        return sysRole;
    }
}
