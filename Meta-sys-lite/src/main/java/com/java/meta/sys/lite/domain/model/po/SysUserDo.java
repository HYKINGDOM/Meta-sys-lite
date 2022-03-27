package com.java.meta.sys.lite.domain.model.po;

import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

/**
 * @author HY
 */
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SysUserDo {

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
        SysUserDo sysUserDo = (SysUserDo) o;
        return id != null && Objects.equals(id, sysUserDo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}