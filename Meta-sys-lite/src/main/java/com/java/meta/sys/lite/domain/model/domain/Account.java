package com.java.meta.sys.lite.domain.model.domain;

import lombok.*;

/**
 * @author HY
 */
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private Long accountId;

    private String accountNumber;

    private String accountName;

    private String accountEmail;

    private Integer emailStatus;

    private Integer accountStatus;

    private String password;
}