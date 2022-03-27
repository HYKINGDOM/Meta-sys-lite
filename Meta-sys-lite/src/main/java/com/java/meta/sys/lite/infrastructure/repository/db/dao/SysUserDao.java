package com.java.meta.sys.lite.infrastructure.repository.db.dao;

import com.java.meta.sys.lite.domain.model.po.SysUserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HY
 */
@Mapper
public interface SysUserDao {


    /**
     * 保存数据
     * @param sysUserDo
     */
    void saveSysUserPo(SysUserDo sysUserDo);

    /**
     * 根据UserAccount 查找user
     * @param userId
     * @return
     */
    SysUserDo findSysUserPoByUserDtoAccount(@Param("userId") Long userId);


    /**
     * 删除User
     * @param userId
     */
    void deleteSysUserPoByUserAccount(@Param("userId") Long userId);

    /**
     * 更新user
     * @param sysUserDo
     */
    void updateSysUserPo(SysUserDo sysUserDo);

}