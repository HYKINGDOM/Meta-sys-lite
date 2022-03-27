package com.java.meta.sys.lite.application.service.serviceImpl;

import com.java.meta.sys.lite.common.utils.GenerateNumberUtils;
import com.java.meta.sys.lite.domain.model.dto.SysUserDTO;
import com.java.meta.sys.lite.domain.model.vo.SysUserPwVo;
import com.java.meta.sys.lite.domain.model.vo.SysUserVo;
import com.java.meta.sys.lite.application.SysUserDTOManager;
import com.java.meta.sys.lite.application.service.SysUserDOService;
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
        SysUserDTO sysUserDTO = SysUserDTO.builder().build();
        BeanUtils.copyProperties(sysUserPwVo, sysUserDTO);
        sysUserDTO.setUserId(GenerateNumberUtils.generateUserIdByNowDate());
        sysUserDTOManager.createUser(sysUserDTO);
    }


    @Override
    public void deleteUser(SysUserVo sysUserVo) {
        sysUserVoValidGroup.deleteSysUserInfoValid(sysUserVo);
        SysUserDTO sysUserDTO = SysUserDTO.builder().build();
        BeanUtils.copyProperties(sysUserVo, sysUserDTO);
        sysUserDTO.setUserId(Long.valueOf(sysUserVo.getUserId()));
        sysUserDTOManager.deleteUser(sysUserDTO);
    }

    @Override
    public SysUserDTO findSysUserByUserAccount(SysUserDTO sysUserDTO) {
        return sysUserDTOManager.findSysUserByUserAccount(sysUserDTO);
    }

    @Override
    public void updateSysUser(SysUserDTO sysUserDTO) {
        sysUserDTOManager.updateSysUser(sysUserDTO);
    }

}
