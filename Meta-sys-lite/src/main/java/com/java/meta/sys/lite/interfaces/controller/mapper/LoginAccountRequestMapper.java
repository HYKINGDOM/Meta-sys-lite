package com.java.meta.sys.lite.interfaces.controller.mapper;

import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.interfaces.controller.request.LoginAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * @author HY
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoginAccountRequestMapper {


    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "password", target = "password")
    })
    Account toAccount(LoginAccountRequest loginAccountRequest);
}
