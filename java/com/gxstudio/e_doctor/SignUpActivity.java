package com.gxstudio.e_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gxstudio.e_doctor.Model.User;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    FirebaseFirestore db;

    EditText Name, Age,PhoneNumber , Email, Password;
    TextView signupBtn;

    SharedPreferences shared;

    Boolean checkName, checkEmail, checkPassword, checkAge, checkPhoneNumber;

    Boolean isLoginSuccessful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = FirebaseFirestore.getInstance();

        shared = this.getSharedPreferences("User", Context.MODE_PRIVATE);

        Boolean skip = shared.getBoolean("isLoginSuccessful",false);

        if (skip.equals(true)){
            Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

        checkName = false;
        checkEmail = false;
        checkPassword = false;
        checkAge = false;
        checkPhoneNumber = false;

        Name = findViewById(R.id.editTextNameSignUp);
        Email = findViewById(R.id.editTextEmailSignUp);
        Age = findViewById(R.id.editTextAgeSignUp);
        PhoneNumber = findViewById(R.id.editTextPhoneNumberSignUp);
        Password = findViewById(R.id.editTextPasswordSignUp);

        signupBtn = findViewById(R.id.signupBtn);


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String age = Age.getText().toString().trim();
                String phoneNumber = PhoneNumber.getText().toString().trim();

                if (!name.isEmpty()){
                    checkName = true;
                }else {
                    checkName = false;
                    Toast.makeText(SignUpActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }

                if (!age.isEmpty()){
                    checkAge = true;
                }else {
                    checkAge = false;
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Age", Toast.LENGTH_SHORT).show();
                }

                if (!phoneNumber.isEmpty()){
                    if (phoneNumber.length() == 10){
                        checkPhoneNumber = true;
                    }else {
                        checkPhoneNumber = false;
                        Toast.makeText(SignUpActivity.this, "Please Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    checkPhoneNumber = false;
                    Toast.makeText(SignUpActivity.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                }

                if (!email.isEmpty()){
                    if (email.length() > 10){
                        checkEmail = true;
                    }else {
                        checkEmail = false;
                        Toast.makeText(SignUpActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    checkEmail = false;
                    Toast.makeText(SignUpActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if (!password.isEmpty()){
                    if (password.length() >= 8){
                        checkPassword = true;
                    }else {
                        checkPassword = false;
                        Toast.makeText(SignUpActivity.this, "Password less than 8 character", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    checkPassword = false;
                    Toast.makeText(SignUpActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }


                if (checkName.equals(true) && checkEmail.equals(true) && checkPassword.equals(true) && checkAge.equals(true) && checkPhoneNumber.equals(true)){

                    Map<String, Object> Users = new HashMap<>();
                    Users.put("Name", name);
                    Users.put("Email", email);
                    Users.put("Password", password);
                    Users.put("Age", age);
                    Users.put("Phone Number", phoneNumber);

                    db.collection("Users")
                            .add(Users)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(SignUpActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);

                                    String id = documentReference.getId();
                                    String referralsCode = id.substring(0,6);

                                    isLoginSuccessful = true;

                                    SharedPreferences.Editor editor = shared.edit();
                                    editor.putBoolean("isLoginSuccessful", isLoginSuccessful);
                                    editor.putString("Name",name);
                                    editor.putString("Email", email);
                                    editor.putString("ID",id);

                                    //User users = new User(name,email,password,age,phoneNumber,id);

                                    editor.apply();

                                    startActivity(intent);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            });

                }

            }
        });

    }
}