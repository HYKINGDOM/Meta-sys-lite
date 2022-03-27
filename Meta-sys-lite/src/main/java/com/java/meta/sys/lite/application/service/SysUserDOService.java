package com.java.meta.sys.lite.application.service;

import com.java.meta.sys.lite.domain.model.dto.SysUserDTO;
import com.java.meta.sys.lite.domain.model.vo.SysUserPwVo;
import com.java.meta.sys.lite.domain.model.vo.SysUserVo;

/**
 * 用户
 * @author HY
 */
public interface SysUserDOService {

    /**
     * 新建用户
     * @param sysUserPwVo
     */
    void createSysUserByVo(SysUserPwVo sysUserPwVo);

    /**
     * 删除用户
     * @param sysUserVo
     */
    void deleteUser(SysUserVo sysUserVo);

    /**
     * 查询数据
     * @param sysUserDTO
     * @return
     */
    SysUserDTO findSysUserByUserAccount(SysUserDTO sysUserDTO);

    /**
     * 更新用户数据
     * @param sysUserDTO
     */
    void updateSysUser(SysUserDTO sysUserDTO);

}
