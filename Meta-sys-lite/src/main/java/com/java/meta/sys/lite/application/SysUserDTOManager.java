package com.java.meta.sys.lite.application;

import cn.hutool.core.util.ObjectUtil;
import com.java.meta.sys.lite.common.exception.constant.ExceptionEnumConstant;
import com.java.meta.sys.lite.common.exception.user.InvalidUserException;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.SysAccountDao;
import com.java.meta.sys.lite.domain.model.dto.SysAccountDto;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.AccountEntity;
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

    private final SysAccountDao sysAccountDao;

    public SysUserDTOManager(SysAccountDao sysAccountDao) {
        this.sysAccountDao = sysAccountDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createUser(SysAccountDto sysAccountDto) {

        AccountEntity accountEntity = sysAccountDao.findSysUserPoByUserDtoAccount(sysAccountDto.getUserId());

        if (ObjectUtil.isNotNull(accountEntity)) {
            throw new InvalidUserException(ExceptionEnumConstant.USER_DATA_ALREADY_EXISTS_EXCEPTION);
        }

        AccountEntity accountEntityEntity = AccountEntity.builder().build();

        BeanUtils.copyProperties(sysAccountDto, accountEntityEntity);

        accountEntityEntity.setEmailStatus(0);
        accountEntityEntity.setAccountStatus(0);
        accountEntityEntity.setCreateBy("admin");
        accountEntityEntity.setCreateTime(Instant.now());

        sysAccountDao.saveSysUserPo(accountEntityEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(SysAccountDto sysAccountDto) {
        sysAccountDao.deleteSysUserPoByUserAccount(sysAccountDto.getUserId());
    }

    public SysAccountDto findSysUserByUserAccount(SysAccountDto sysAccountDto) {
        AccountEntity accountEntity = sysAccountDao.findSysUserPoByUserDtoAccount(sysAccountDto.getUserId());

        if (ObjectUtil.isNull(accountEntity)) {
            return SysAccountDto.builder().build();
        }

        SysAccountDto userDTO = SysAccountDto.builder().build();
        BeanUtils.copyProperties(accountEntity, userDTO);
        return userDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysAccountDto sysAccountDto) {
        AccountEntity accountEntity = AccountEntity.builder()
                .updateBy("admin")
                .updateTime(Instant.now())
                .build();
        BeanUtils.copyProperties(sysAccountDto, accountEntity);
        sysAccountDao.updateSysUserPo(accountEntity);
    }
}
