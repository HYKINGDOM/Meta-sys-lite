package com.java.meta.sys.lite.domain.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author HY
 */
@Builder
@Data
public class SysAccountDto {

    private Long userId;

    private String userAccount;

    private String userName;

    private String userEmail;

    private Integer emailStatus;

    private Integer accountStatus;

    private String userPassword;
}
