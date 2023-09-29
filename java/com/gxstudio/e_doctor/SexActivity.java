package com.gxstudio.e_doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SexActivity extends AppCompatActivity {

    TextView maleBtn, femaleBtn;
    String sex, testType, agetext;

    Integer age;

    EditText ageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        maleBtn = findViewById(R.id.maleSexBtn);
        femaleBtn = findViewById(R.id.femaleSexBtn);

        testType = getIntent().getStringExtra("TestType");

        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ageInput = findViewById(R.id.ageEditText);
                agetext = ageInput.getText().toString().trim();

                if (!"".equals(agetext)){
                    if (!agetext.equals("00") && !agetext.equals("0")){
                        sex = "Male";

                        Intent intent = new Intent(SexActivity.this, ScanMethodActivity.class);
                        intent.putExtra("Sex", sex);
                        intent.putExtra("TestType", testType);
                        intent.putExtra("Age", agetext);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SexActivity.this, "الرجاء ادخال عمر صالح", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SexActivity.this, "الرجاء ادخال عمرك", Toast.LENGTH_SHORT).show();
                }
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageInput = findViewById(R.id.ageEditText);
                agetext = ageInput.getText().toString().trim();

                if (!"".equals(agetext)){
                    if (!agetext.equals("00") && !agetext.equals("0")){
                        sex = "Female";

                        Intent intent = new Intent(SexActivity.this, ScanMethodActivity.class);
                        intent.putExtra("Sex", sex);
                        intent.putExtra("TestType", testType);
                        intent.putExtra("Age", agetext);
                        startActivity(intent);
                        }else {
                            Toast.makeText(SexActivity.this, "الرجاء ادخال عمر صالح", Toast.LENGTH_SHORT).show();
                        }
                }else {
                    Toast.makeText(SexActivity.this, "الرجاء ادخال عمرك", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}