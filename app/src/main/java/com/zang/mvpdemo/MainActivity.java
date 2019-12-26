package com.zang.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zang.mvpdemo.presenter.ILoginPresenter;
import com.zang.mvpdemo.presenter.LoginPresenter;
import com.zang.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private ILoginPresenter mILoginPresenter;
    private EditText mEmailEdt;
    private EditText mPassEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mILoginPresenter = new LoginPresenter(this);

        mEmailEdt = findViewById(R.id.email_edt);
        mPassEdt = findViewById(R.id.password_edt);
        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                mILoginPresenter.onLogin(mEmailEdt.getText().toString(), mPassEdt.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
