package com.java.meta.sys.lite.interfaces.controller.request;

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
@NoArgsConstructor
@AllArgsConstructor
public class LoginAccountRequest {

    private String accountNumber;

    private String password;
}
