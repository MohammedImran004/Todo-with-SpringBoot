package com.imran.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationController {
    public boolean authenticate(String name, String password){
        boolean isValidName = name.equalsIgnoreCase("Imran");
        boolean isValidPassword = password.equalsIgnoreCase("1234");
        return isValidName && isValidPassword;
    }
}
