package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.service.LoginAccountService;
import com.java.meta.sys.lite.service.port.SysAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author HY
 */
@Service
@RequiredArgsConstructor
public class LoginAccountServiceImpl implements LoginAccountService {


    private final SysAccountRepository sysAccountRepository;

    @Override
    public Account loginAccount(Account account) {
        return sysAccountRepository.getAccount(account);
    }
}
