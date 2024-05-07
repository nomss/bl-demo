package com.ayeeti.blservice.controller;

import com.ayeeti.blservice.model.HelloWorld;
import com.ayeeti.blservice.model.LoginModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public LoginModel login(@RequestBody LoginModel loginModel) {
        System.out.println("loginModel.getUserName(): " + loginModel.getUserName());
        return loginModel;
    }

}
