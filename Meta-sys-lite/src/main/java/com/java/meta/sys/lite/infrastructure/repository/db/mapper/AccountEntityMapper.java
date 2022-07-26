package com.java.meta.sys.lite.infrastructure.repository.db.mapper;

import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author HY
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountEntityMapper {


    AccountEntity toAccountEntity(Account account);


    Account toAccount(AccountEntity accountEntity);
}
