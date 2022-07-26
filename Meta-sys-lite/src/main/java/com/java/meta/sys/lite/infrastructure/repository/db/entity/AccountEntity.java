package com.java.meta.sys.lite.infrastructure.repository.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.Instant;

/**
 * @author HY
 */
@Builder
@Data
@AllArgsConstructor
@TableName("sys_account")
public class AccountEntity {

    private Long id;

    private Long accountId;

    private String accountNumber;

    private String accountEmail;

    private Integer emailStatus;

    private Integer accountStatus;

    private String password;

    private String createBy;

    private Instant createTime;

    private String updateBy;

    private Instant updateTime;
}