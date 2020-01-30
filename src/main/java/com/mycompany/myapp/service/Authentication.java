package com.mycompany.myapp.service;

import com.mycompany.app.Person;

public abstract class Authentication {

    protected abstract Person login(String username, String password);

    public void authenticate(String username, String password){
        Person logged = login(username, password);

        if(logged == null){
            return;
        }
    }
}
