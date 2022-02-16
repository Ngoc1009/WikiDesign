package com.example.wikidesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.switchFaceID)
    SwitchCompat switchFaceID;
    @BindView(R.id.switchTouchID)
    SwitchCompat switchTouchID;
    @BindView(R.id.tvAuth)
    TextView tvAuth;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

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
        if (switchFaceID.isChecked() || switchTouchID.isChecked()){
            checkLogin();
        }

    }

    public void checkLogin(){
        BiometricManager biometricManager = BiometricManager.from(this);
        if (biometricManager.canAuthenticate() != BiometricManager.BIOMETRIC_SUCCESS){

            tvAuth.setText("Biometric Not Supported");
            return;
        }else {
            executor = ContextCompat.getMainExecutor(this);
            biometricPrompt = new BiometricPrompt(LoginActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    tvAuth.setText("Login by user account");

                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    tvAuth.setText("Login success");
                    WelcomeActivity.startMe(LoginActivity.this);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    tvAuth.setText("Login failed, please check information");
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Biometric login for my app")
                    .setConfirmationRequired(false)
                    .setSubtitle("Log in using your biometric credential")
                    .setNegativeButtonText("Use account password")
                    .build();
            biometricPrompt.authenticate(promptInfo);
        }
    }



}