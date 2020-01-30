package com.mycompany.myapp.service;

import com.mycompany.app.Person;

public class DatabaseAuthentication extends Authentication {

    @Override
    protected Person login(String username, String password) {
        if(username.equalsIgnoreCase("admin") && password.equals("admin")){
            return new Person();
        }
        return null;
    }
}
