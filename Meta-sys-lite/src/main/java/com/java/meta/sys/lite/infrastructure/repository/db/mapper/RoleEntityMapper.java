package com.java.meta.sys.lite.infrastructure.repository.db.mapper;


import com.java.meta.sys.lite.domain.model.domain.Role;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * @author HY
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {

    @Mappings({
            @Mapping(source = "roleId", target = "roleId")
    })
    RoleEntity toRoleEntity(Role role);


}
