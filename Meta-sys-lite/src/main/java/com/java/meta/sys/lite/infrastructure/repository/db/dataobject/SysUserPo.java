package com.java.meta.sys.lite.infrastructure.repository.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.Instant;

/**
 * @author HY
 */
@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class SysUserPo {

    private Long id;

    private Long userId;

    private String userAccount;

    private String userName;

    private String userEmail;

    private Integer emailStatus;

    private Integer accountStatus;

    private String userPassword;

    private String createBy;

    private Instant createTime;

    private String updateBy;

    private Instant updateTime;
}