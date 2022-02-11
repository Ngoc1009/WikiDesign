package com.example.wikidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class RegistrationCompletedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_completed);
    }

    public static void startMe(Context context){
        context.startActivity(new Intent(context, RegistrationCompletedActivity.class));
    }
}