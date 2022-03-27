package com.java.meta.sys.lite.application;

import cn.hutool.core.util.ObjectUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.SysUserDao;
import com.java.meta.sys.lite.domain.model.dto.SysUserDTO;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysUserPo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

/**
 *
 * 数据处理
 * @author HY
 */
@Service
public class SysUserDTOManager {

    private final SysUserDao sysUserDao;

    public SysUserDTOManager(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createUser(SysUserDTO sysUserDTO) {

        SysUserPo sysUserPo = sysUserDao.findSysUserPoByUserDtoAccount(sysUserDTO.getUserId());

        if (ObjectUtil.isNotNull(sysUserPo)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_ALREADY_EXISTS_EXCEPTION);
        }

        SysUserPo sysUserPoEntity = SysUserPo.builder().build();

        BeanUtils.copyProperties(sysUserDTO, sysUserPoEntity);

        sysUserPoEntity.setEmailStatus(0);
        sysUserPoEntity.setAccountStatus(0);
        sysUserPoEntity.setCreateBy("admin");
        sysUserPoEntity.setCreateTime(Instant.now());

        sysUserDao.saveSysUserPo(sysUserPoEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(SysUserDTO sysUserDTO) {
        sysUserDao.deleteSysUserPoByUserAccount(sysUserDTO.getUserId());
    }

    public SysUserDTO findSysUserByUserAccount(SysUserDTO sysUserDTO) {
        SysUserPo sysUserPo = sysUserDao.findSysUserPoByUserDtoAccount(sysUserDTO.getUserId());

        if (ObjectUtil.isNull(sysUserPo)) {
            return SysUserDTO.builder().build();
        }

        SysUserDTO userDTO = SysUserDTO.builder().build();
        BeanUtils.copyProperties(sysUserPo, userDTO);
        return userDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUserDTO sysUserDTO) {
        SysUserPo sysUserPo = SysUserPo.builder()
                .updateBy("admin")
                .updateTime(Instant.now())
                .build();
        BeanUtils.copyProperties(sysUserDTO, sysUserPo);
        sysUserDao.updateSysUserPo(sysUserPo);
    }
}
