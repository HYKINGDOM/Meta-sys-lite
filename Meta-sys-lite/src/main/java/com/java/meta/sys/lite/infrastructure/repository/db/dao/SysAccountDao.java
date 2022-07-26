package com.java.meta.sys.lite.infrastructure.repository.db.dao;

import com.java.meta.sys.lite.infrastructure.repository.db.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HY
 */
@Mapper
public interface SysAccountDao {


    /**
     * 保存数据
     *
     * @param accountEntity
     */
    void saveSysUserPo(AccountEntity accountEntity);

    /**
     * 根据UserAccount 查找user
     *
     * @param userId
     * @return
     */
    AccountEntity findSysUserPoByUserDtoAccount(@Param("userId") Long userId);


    /**
     * 删除User
     * @param userId
     */
    void deleteSysUserPoByUserAccount(@Param("userId") Long userId);

    /**
     * 更新user
     *
     * @param accountEntity
     */
    void updateSysUserPo(AccountEntity accountEntity);

}