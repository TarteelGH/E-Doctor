package com.gxstudio.e_doctor;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    FirebaseFirestore db;

    EditText Email, Password;
    TextView loginBtn;

    SharedPreferences shared;

    String CorrectEmail,CorrectPassword,Name,Id,PhoneNumber,Age;

    Boolean checkEmail = false;
    Boolean checkPassword = false;

    Boolean isLoginSuccessful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = FirebaseFirestore.getInstance();

        shared = this.getSharedPreferences("User", Context.MODE_PRIVATE);

        Email = findViewById(R.id.editTextEmailLogin);
        Password = findViewById(R.id.editTextPasswordLogin);

        loginBtn = findViewById(R.id.loginBtn);

        Boolean skip = shared.getBoolean("isLoginSuccessful",false);

        if (skip.equals(true)){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (!email.isEmpty()){
                    if (email.length() > 10){
                        checkEmail = true;
                    }else {
                        checkEmail = false;
                        Toast.makeText(LoginActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    checkEmail = false;
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if (!password.isEmpty()){
                    if (password.length() >= 8){
                        checkPassword = true;
                    }else {
                        checkPassword = false;
                        Toast.makeText(LoginActivity.this, "Password less than 8 characters", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    checkPassword = false;
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }

                if (checkEmail.equals(true) && checkPassword.equals(true)){

                    db.collection("Users")
                            .whereEqualTo("Email", email)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                    if (task.isSuccessful()){
                                        for (QueryDocumentSnapshot document : task.getResult()){

                                            Log.d(TAG, document.getId() + "=>" + document.getData());
                                            CorrectEmail = document.get("Email").toString();
                                            CorrectPassword = document.get("Password").toString();
                                            Name = document.get("Name").toString();
                                            Id = document.getId();
                                        }

                                        if (email.equals(CorrectEmail) && password.equals(CorrectPassword)){
                                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                            isLoginSuccessful = true;

                                            SharedPreferences.Editor editor = shared.edit();
                                            editor.putString("ID",Id);
                                            editor.putBoolean("isLoginSuccessful", isLoginSuccessful);
                                            editor.putString("Name",Name);
                                            editor.putString("Email", CorrectEmail);
                                            editor.putString("ID", Id);
                                            editor.apply();

                                            startActivity(intent);
                                            finish();
                                        }else {
                                            Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });

                }
            }
        });

    }
}