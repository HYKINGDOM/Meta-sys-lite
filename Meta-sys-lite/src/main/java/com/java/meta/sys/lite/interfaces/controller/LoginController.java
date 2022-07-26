package com.java.meta.sys.lite.interfaces.controller;


import com.java.meta.sys.lite.common.utils.rest.SyncResult;
import com.java.meta.sys.lite.domain.model.domain.Account;
import com.java.meta.sys.lite.interfaces.controller.mapper.LoginAccountRequestMapper;
import com.java.meta.sys.lite.interfaces.controller.request.LoginAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author HY
 */
@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {


    private final LoginAccountRequestMapper loginAccountRequestMapper;


    @PostMapping
    public SyncResult loginForAccount(@RequestBody LoginAccountRequest loginAccountRequest){

        Account account = loginAccountRequestMapper.toAccount(loginAccountRequest);
        return SyncResult.success(account);
    }


}
