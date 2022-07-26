package com.java.meta.sys.lite.interfaces.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author HY
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private Long id;

    private Long accountId;

    private String userAccount;

    private String accountName;

    private String accountEmail;

    private Integer emailStatus;

    private Integer accountStatus;

    private String password;
}
