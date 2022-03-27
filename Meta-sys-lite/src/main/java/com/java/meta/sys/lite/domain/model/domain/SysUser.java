package com.java.meta.sys.lite.domain.model.domain;

import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

/**
 * @author HY
 */
@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SysUser {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        return id != null && Objects.equals(id, sysUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}