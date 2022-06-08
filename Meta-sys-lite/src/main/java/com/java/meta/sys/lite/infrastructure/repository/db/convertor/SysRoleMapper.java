package com.java.meta.sys.lite.infrastructure.repository.db.convertor;


import com.java.meta.sys.lite.domain.model.domain.SysRole;
import com.java.meta.sys.lite.infrastructure.repository.db.dataobject.SysRolePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author HY
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleMapper {

    @Mappings({
            @Mapping(source = "roleId", target = "roleId")
    })
    SysRolePo toSysRolePo(SysRole sysRole);


}
