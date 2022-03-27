package com.java.meta.sys.lite.infrastructure.repository.db.dao;

import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysUserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HY
 */
@Mapper
public interface SysUserDao {


    /**
     * 保存数据
     *
     * @param sysUserPo
     */
    void saveSysUserPo(SysUserPo sysUserPo);

    /**
     * 根据UserAccount 查找user
     *
     * @param userId
     * @return
     */
    SysUserPo findSysUserPoByUserDtoAccount(@Param("userId") Long userId);


    /**
     * 删除User
     * @param userId
     */
    void deleteSysUserPoByUserAccount(@Param("userId") Long userId);

    /**
     * 更新user
     *
     * @param sysUserPo
     */
    void updateSysUserPo(SysUserPo sysUserPo);

}