package com.zang.mvpdemo.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean validUser() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 0;
    }
}
