package com.example.wikidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.tvLanding)
    void OnClickLanding(){
        LandingActivity.starMe(this);
    }

    @OnClick(R.id.tvAllFilter)
    void OnClickAllFilter(){
        AllFilterActivity.startMe(this);
    }

    @OnClick(R.id.tvLogin)
    void OnClickLogin(){
        LoginActivity.startMe(this);
    }

    @OnClick(R.id.tvProfile)
    void OnClickProfile(){
        ProfileActivity.startMe(this);
    }

    @OnClick(R.id.tvRegistration)
    void OnClickRegistrationCompleted(){
        RegistrationCompletedActivity.startMe(this);
    }

    @OnClick(R.id.tvSignIn)
    void OnClickSignIn(){
        SignInActivity.startMe(this);
    }

    @OnClick(R.id.tvSplashScreen)
    void OnClickSplash(){
        SplashScreenActivity.startMe(this);
    }

    @OnClick(R.id.tvWelcome)
    void OnClickWelcome(){
        WelcomeActivity.startMe(this);
    }
}