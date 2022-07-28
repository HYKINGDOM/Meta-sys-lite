package com.java.meta.sys.lite.service;

import com.java.meta.sys.lite.domain.model.domain.Account;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountAuthService {
    UserDetails getAccountDetails(String accountNumber);

    Account loginAccount(Account account);
}
