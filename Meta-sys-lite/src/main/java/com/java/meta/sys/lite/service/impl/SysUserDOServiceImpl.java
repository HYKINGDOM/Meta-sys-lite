package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.common.utils.GenerateNumberUtils;
import com.java.meta.sys.lite.domain.model.dto.SysAccountDto;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserPwVo;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserVo;
import com.java.meta.sys.lite.application.SysUserDTOManager;
import com.java.meta.sys.lite.service.SysUserDOService;
import com.java.meta.sys.lite.application.rules.SysUserVoValidGroup;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * 数据处理类
 *
 * @author HY
 */
@Service
public class SysUserDOServiceImpl implements SysUserDOService {

    private final SysUserDTOManager sysUserDTOManager;

    private final SysUserVoValidGroup sysUserVoValidGroup;

    public SysUserDOServiceImpl(SysUserDTOManager sysUserDTOManager, SysUserVoValidGroup sysUserVoValidGroup) {
        this.sysUserDTOManager = sysUserDTOManager;
        this.sysUserVoValidGroup = sysUserVoValidGroup;
    }

    @Override
    public void createSysUserByVo(SysUserPwVo sysUserPwVo) {
        sysUserVoValidGroup.createSysUserInfoValid(sysUserPwVo);
        SysAccountDto sysAccountDto = SysAccountDto.builder().build();
        BeanUtils.copyProperties(sysUserPwVo, sysAccountDto);
        sysAccountDto.setUserId(GenerateNumberUtils.generateUserIdByNowDate());
        sysUserDTOManager.createUser(sysAccountDto);
    }


    @Override
    public void deleteUser(SysUserVo sysUserVo) {
        sysUserVoValidGroup.deleteSysUserInfoValid(sysUserVo);
        SysAccountDto sysAccountDto = SysAccountDto.builder().build();
        BeanUtils.copyProperties(sysUserVo, sysAccountDto);
        sysAccountDto.setUserId(Long.valueOf(sysUserVo.getUserId()));
        sysUserDTOManager.deleteUser(sysAccountDto);
    }

    @Override
    public SysAccountDto findSysUserByUserAccount(SysAccountDto sysAccountDto) {
        return sysUserDTOManager.findSysUserByUserAccount(sysAccountDto);
    }

    @Override
    public void updateSysUser(SysAccountDto sysAccountDto) {
        sysUserDTOManager.updateSysUser(sysAccountDto);
    }

}
