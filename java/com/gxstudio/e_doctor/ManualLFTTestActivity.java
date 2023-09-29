package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManualLFTTestActivity extends AppCompatActivity {


    EditText altInput, aptInput, astInput, ggtInput, tbiliInput, globulinInput;
    Double alt, apt, ast, ggt, tbili, globulin;
    String alttext, apttext, asttext, ggttext, tbilitext, globulintext, gender;

    Integer age;
    TextView resultBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_lfttest);

        gender = getIntent().getStringExtra("Sex");

        age = getIntent().getIntExtra("Age", 0);

        resultBtn = findViewById(R.id.resultBtnCBCManualPage);


        altInput = findViewById(R.id.altEditText);
        aptInput = findViewById(R.id.aptEditText);
        astInput = findViewById(R.id.astEditText);
        ggtInput = findViewById(R.id.ggtEditText);
        tbiliInput = findViewById(R.id.tbiliEditText);
        globulinInput = findViewById(R.id.globulinEditText);

        resultBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alttext = altInput.getText().toString().trim();
                apttext = aptInput.getText().toString().trim();
                asttext = astInput.getText().toString().trim();
                ggttext = ggtInput.getText().toString().trim();
                tbilitext = tbiliInput.getText().toString().trim();
                globulintext = globulinInput.getText().toString().trim();

                if (!"".equals(alttext)){
                    if (!"".equals(apttext)){
                        if (!"".equals(asttext)){
                            if (!"".equals(ggttext)){
                                if (!"".equals(tbilitext)){
                                    if(!"".equals(globulintext)) {

                                        alt = Double.parseDouble(alttext);
                                        apt = Double.parseDouble(apttext);
                                        ast = Double.parseDouble(asttext);
                                        ggt = Double.parseDouble(ggttext);
                                        tbili = Double.parseDouble(tbilitext);
                                        globulin = Double.parseDouble(globulintext);

                                        Intent intent = new Intent(ManualLFTTestActivity.this, FATTestResultActivity.class);
                                        intent.putExtra("RBC", alt);
                                        intent.putExtra("WBC", apt);
                                        intent.putExtra("HGB", ast);
                                        intent.putExtra("HCT", ggt);
                                        intent.putExtra("PLT", tbili);
                                        intent.putExtra("Globulin", globulin);
                                        intent.putExtra("Sex", gender);
                                        intent.putExtra("Age", age);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ManualLFTTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}