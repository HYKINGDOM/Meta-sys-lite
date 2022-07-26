package com.java.meta.sys.lite.domain.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HY
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer roleId;

    private String roleName;

    private Integer parentRoleId;

    private Integer roleStatus;
}
