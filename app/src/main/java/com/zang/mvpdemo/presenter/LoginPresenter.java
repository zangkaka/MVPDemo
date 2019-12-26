package com.zang.mvpdemo.presenter;

import com.zang.mvpdemo.model.User;
import com.zang.mvpdemo.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSuccess = user.validUser();
        if (isLoginSuccess) {
            loginView.onLoginResult("Login success");
        } else {
            loginView.onLoginResult("Login error");
        }
    }
}
