package com.java.meta.sys.lite.infrastructure.repository.db.convertor;


import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysRolePo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author HY
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleMapper {

    SysRolePo toSysRolePo(SysRole sysRole);
}
