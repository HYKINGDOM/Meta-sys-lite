package com.java.meta.sys.lite.service.impl;

import com.java.meta.sys.lite.service.AccountService;
import org.springframework.stereotype.Service;


@Service
public class EmployeeAccountServiceImpl implements AccountService {

    private final static String EMPLOYEE_ACCOUNT_TYPE = "employee_type";

    @Override
    public String getAccountName(String accountId) {
        return EMPLOYEE_ACCOUNT_TYPE;
    }

    @Override
    public boolean isAccountType(String accountType) {
        return EMPLOYEE_ACCOUNT_TYPE.equalsIgnoreCase(accountType);
    }
}
