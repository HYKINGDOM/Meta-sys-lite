package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.domain.AccountAuthDetails;
import com.java.meta.sys.lite.domain.AccountResource;
import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.service.AccountAuthService;
import com.java.meta.sys.lite.service.port.SysAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HY
 */
@Service
@RequiredArgsConstructor
public class AccountAuthServiceImpl implements AccountAuthService {


    private final SysAccountRepository sysAccountRepository;

    @Override
    public UserDetails getAccountDetails(String accountNumber) {
        Account account = Account.builder().accountNumber(accountNumber).build();
        Account accountResult = sysAccountRepository.getAccount(account);
        if (accountResult != null) {
            //todo
            List<AccountResource> resourceList = new ArrayList<>();
            return AccountAuthDetails.builder().account(accountResult).accountResources(resourceList).build();
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public Account loginAccount(Account account) {
        return sysAccountRepository.getAccount(account);
    }
}
