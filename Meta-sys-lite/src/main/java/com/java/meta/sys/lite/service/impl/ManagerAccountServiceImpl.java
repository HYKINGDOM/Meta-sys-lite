package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ManagerAccountServiceImpl implements AccountService {

    private final static String MANAGER_ACCOUNT_TYPE = "manager_type";

    @Override
    public String getAccountName(String accountId) {
        return MANAGER_ACCOUNT_TYPE;
    }

    @Override
    public boolean isAccountType(String accountType) {
        return MANAGER_ACCOUNT_TYPE.equalsIgnoreCase(accountType);
    }
}
