package com.gxstudio.e_doctor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManualCBCTestActivity extends AppCompatActivity {

    EditText rbcInput, wbcInput, hgbInput, hctInput, pltInput;
    Double rbc, wbc, hgb, hct, plt;
    String  rbctext, wbctext, hgbtext, hcttext, plttext, gender;

    Integer age;
    TextView resultBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_cbctest);

        gender = getIntent().getStringExtra("Sex");

        age = getIntent().getIntExtra("Age",0);

        resultBtn = findViewById(R.id.resultBtnCBCManualPage);

        rbcInput = findViewById(R.id.rcbEditText);
        wbcInput = findViewById(R.id.wcbEditText);
        hgbInput = findViewById(R.id.hgbEditText);
        hctInput = findViewById(R.id.hctEditText);
        pltInput = findViewById(R.id.pltEditText);


        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbctext = rbcInput.getText().toString().trim();
                wbctext = wbcInput.getText().toString().trim();
                hgbtext = hgbInput.getText().toString().trim();
                hcttext = hctInput.getText().toString().trim();
                plttext = pltInput.getText().toString().trim();

                if (!"".equals(rbctext)){
                    if (!"".equals(wbctext)){
                        if (!"".equals(hgbtext)){
                            if (!"".equals(hcttext)){
                                if (!"".equals(plttext)){

                                    rbc = Double.parseDouble(rbctext);
                                    wbc = Double.parseDouble(wbctext);
                                    hgb = Double.parseDouble(hgbtext);
                                    hct = Double.parseDouble(hcttext);
                                    plt = Double.parseDouble(plttext);

                                    Intent intent = new Intent(ManualCBCTestActivity.this, CBCTestResultActivity.class);
                                    intent.putExtra("RBC", rbc);
                                    intent.putExtra("WBC", wbc);
                                    intent.putExtra("HGB", hgb);
                                    intent.putExtra("HCT", hct);
                                    intent.putExtra("PLT", plt);
                                    intent.putExtra("Sex", gender);
                                    intent.putExtra("Age", age);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(ManualCBCTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(ManualCBCTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(ManualCBCTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(ManualCBCTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ManualCBCTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}