package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView gotoLoginPage,gotoSignUpPage,gotoAboutAppPage;

    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = this.getSharedPreferences("User", Context.MODE_PRIVATE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Boolean skip = shared.getBoolean("isLoginSuccessful",false);

                if (skip.equals(true)){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1000);


        gotoLoginPage = findViewById(R.id.loginBtnPage);
        gotoSignUpPage = findViewById(R.id.signupBtnPage);
        gotoAboutAppPage = findViewById(R.id.aboutAppBtnPage);

        gotoLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentloginPage = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentloginPage);

            }
        });

        gotoSignUpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsignupPage = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intentsignupPage);
            }
        });

        gotoAboutAppPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentaboutAppPage = new Intent(MainActivity.this, AboutAppActivity.class);
                startActivity(intentaboutAppPage);
            }
        });
    }
}