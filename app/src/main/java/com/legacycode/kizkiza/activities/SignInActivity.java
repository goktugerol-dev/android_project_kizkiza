package com.legacycode.kizkiza.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.legacycode.kizkiza.R;

public class SignInActivity extends AppCompatActivity implements FacebookCallback <LoginResult> {

    LoginButton fb_login_button;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        fb_login_button = findViewById(R.id.fb_login_button);
        callbackManager = CallbackManager.Factory.create();

        fb_login_button.registerCallback(callbackManager, this);


        //Util.keyHashes(this); -- no utilize
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Toast.makeText(this, "LogIn Sucessful!!!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}