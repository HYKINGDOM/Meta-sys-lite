package com.java.meta.sys.lite.domain.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HY
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {

    private Integer roleId;

    private String roleName;

    private Integer parentRoleId;

    private Integer roleStatus;
}
