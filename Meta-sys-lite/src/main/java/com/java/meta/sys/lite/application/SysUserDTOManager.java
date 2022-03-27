package com.java.meta.sys.lite.application;

import cn.hutool.core.util.ObjectUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.SysUserDao;
import com.java.meta.sys.lite.domain.model.dto.SysUserDTO;
import com.java.meta.sys.lite.domain.model.po.SysUserDo;
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

        SysUserDo sysUserDo = sysUserDao.findSysUserPoByUserDtoAccount(sysUserDTO.getUserId());

        if (ObjectUtil.isNotNull(sysUserDo)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_ALREADY_EXISTS_EXCEPTION);
        }

        SysUserDo sysUserDoEntity = SysUserDo.builder().build();

        BeanUtils.copyProperties(sysUserDTO, sysUserDoEntity);

        sysUserDoEntity.setEmailStatus(0);
        sysUserDoEntity.setAccountStatus(0);
        sysUserDoEntity.setCreateBy("admin");
        sysUserDoEntity.setCreateTime(Instant.now());

        sysUserDao.saveSysUserPo(sysUserDoEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(SysUserDTO sysUserDTO) {
        sysUserDao.deleteSysUserPoByUserAccount(sysUserDTO.getUserId());
    }

    public SysUserDTO findSysUserByUserAccount(SysUserDTO sysUserDTO) {
        SysUserDo sysUserDo = sysUserDao.findSysUserPoByUserDtoAccount(sysUserDTO.getUserId());

        if (ObjectUtil.isNull(sysUserDo)) {
            return SysUserDTO.builder().build();
        }

        SysUserDTO userDTO = SysUserDTO.builder().build();
        BeanUtils.copyProperties(sysUserDo, userDTO);
        return userDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUserDTO sysUserDTO) {
        SysUserDo sysUserDo = SysUserDo.builder()
                .updateBy("admin")
                .updateTime(Instant.now())
                .build();
        BeanUtils.copyProperties(sysUserDTO, sysUserDo);
        sysUserDao.updateSysUserPo(sysUserDo);
    }
}
