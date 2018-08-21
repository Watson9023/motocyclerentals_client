package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.LoginEmbeddable;

/**
 * Created by Long on 4/24/2018.
 */
public class LoginEmbeddableFactory {
    public static LoginEmbeddable createLogin(String username, String password)
    {
        LoginEmbeddable loginEmbeddable = new LoginEmbeddable
                .Builder(username)
                .password(password)
                .build();
        return loginEmbeddable;
    }
}
