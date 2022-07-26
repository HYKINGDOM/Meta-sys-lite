package com.java.meta.sys.lite.infrastructure.repository.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.infrastructure.repository.db.dao.AccountDao;
import com.java.meta.sys.lite.infrastructure.repository.db.entity.AccountEntity;
import com.java.meta.sys.lite.infrastructure.repository.db.mapper.AccountEntityMapper;
import com.java.meta.sys.lite.service.port.SysAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SysAccountRepositoryImpl implements SysAccountRepository {

    private final AccountDao accountDao;

    private final AccountEntityMapper accountEntityMapper;

    @Override
    public Account getAccount(Account account) {
        AccountEntity accountEntity = accountEntityMapper.toAccountEntity(account);
        QueryWrapper<AccountEntity> accountEntityQueryWrapper = new QueryWrapper<>();
        accountEntityQueryWrapper.lambda().eq(AccountEntity::getAccountNumber, accountEntity.getAccountNumber());
        AccountEntity resultEntity = accountDao.selectOne(accountEntityQueryWrapper);
        return accountEntityMapper.toAccount(resultEntity);
    }
}
