package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TestTypeActivity extends AppCompatActivity {

    TextView cbcTest,urinalysisTest,hba1cTest,cholesterolTest,lftTest,nextBtn;
    String testType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_type);

        cbcTest = findViewById(R.id.cbcTest);
        urinalysisTest = findViewById(R.id.urinalysisTest);
        hba1cTest = findViewById(R.id.hba1cTest);
        cholesterolTest = findViewById(R.id.cholesterolTest);
        lftTest = findViewById(R.id.lftTest);

        nextBtn = findViewById(R.id.nextBtnPageTestType);

        cbcTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testType = "CBC";
                cbcTest.setTextColor(Color.parseColor("#FF4CAF50"));
                urinalysisTest.setTextColor(Color.parseColor("#FF000000"));
                hba1cTest.setTextColor(Color.parseColor("#FF000000"));
                cholesterolTest.setTextColor(Color.parseColor("#FF000000"));
                lftTest.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        urinalysisTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testType = "Urinalysis";
                cbcTest.setTextColor(Color.parseColor("#FF000000"));
                urinalysisTest.setTextColor(Color.parseColor("#FF4CAF50"));
                hba1cTest.setTextColor(Color.parseColor("#FF000000"));
                cholesterolTest.setTextColor(Color.parseColor("#FF000000"));
                lftTest.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        hba1cTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testType = "HbA1c";
                cbcTest.setTextColor(Color.parseColor("#FF000000"));
                urinalysisTest.setTextColor(Color.parseColor("#FF000000"));
                hba1cTest.setTextColor(Color.parseColor("#FF4CAF50"));
                cholesterolTest.setTextColor(Color.parseColor("#FF000000"));
                lftTest.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        cholesterolTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testType = "Cholesterol";
                cbcTest.setTextColor(Color.parseColor("#FF000000"));
                urinalysisTest.setTextColor(Color.parseColor("#FF000000"));
                hba1cTest.setTextColor(Color.parseColor("#FF000000"));
                cholesterolTest.setTextColor(Color.parseColor("#FF4CAF50"));
                lftTest.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        lftTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testType = "LFT";
                cbcTest.setTextColor(Color.parseColor("#FF000000"));
                urinalysisTest.setTextColor(Color.parseColor("#FF000000"));
                hba1cTest.setTextColor(Color.parseColor("#FF000000"));
                cholesterolTest.setTextColor(Color.parseColor("#FF000000"));
                lftTest.setTextColor(Color.parseColor("#FF4CAF50"));
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testType == null){
                    Toast.makeText(TestTypeActivity.this, "الرجاء اختيار فحص", Toast.LENGTH_SHORT).show();
                /*}else if (testType.equals("HbA1c")) {
                    Intent intent = new Intent(TestTypeActivity.this, ScanMethodActivity.class);
                    intent.putExtra("TestType", testType);
                    startActivity(intent);*/
                }else {
                    Intent intent = new Intent(TestTypeActivity.this, SexActivity.class);
                    intent.putExtra("TestType", testType);
                    startActivity(intent);
                }
            }
        });

    }
}