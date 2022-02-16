package com.example.wikidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    public static void startMe(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @OnClick(R.id.ivLoginArrowBack)
    void OnClickBack(){
        SignInAndRegisterActivity.startMe(this);
    }

    @OnClick(R.id.btnSignIn)
    void OnClickIntentWelcome(){
        WelcomeActivity.startMe(this);
    }
}