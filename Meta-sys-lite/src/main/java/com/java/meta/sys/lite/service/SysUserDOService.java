package com.java.meta.sys.lite.service;

import com.java.meta.sys.lite.domain.model.dto.SysAccountDto;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserPwVo;
import com.java.meta.sys.lite.interfaces.controller.request.SysUserVo;

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
     * @param sysAccountDto
     * @return
     */
    SysAccountDto findSysUserByUserAccount(SysAccountDto sysAccountDto);

    /**
     * 更新用户数据
     * @param sysAccountDto
     */
    void updateSysUser(SysAccountDto sysAccountDto);

}
