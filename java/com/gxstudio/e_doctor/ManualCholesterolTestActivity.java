package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManualCholesterolTestActivity extends AppCompatActivity {

    EditText hdlcInput, ldlcInput, triglyceridesInput, cholestrolInput;
    Double hdlc, ldlc, triglycerides, cholestrol;
    String  hdlctext, ldlctext, triglyceridestext, cholestroltext, gender;

    Integer age;
    TextView resultBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_cholesterol_test);

        gender = getIntent().getStringExtra("Sex");

        age = getIntent().getIntExtra("Age",0);

        resultBtn = findViewById(R.id.resultBtnCholestrolManualPage);

        hdlcInput = findViewById(R.id.rcbEditText);
        ldlcInput = findViewById(R.id.wcbEditText);
        triglyceridesInput = findViewById(R.id.hgbEditText);
        cholestrolInput = findViewById(R.id.hctEditText);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hdlctext = hdlcInput.getText().toString().trim();
                ldlctext = ldlcInput.getText().toString().trim();
                triglyceridestext = triglyceridesInput.getText().toString().trim();
                cholestroltext = cholestrolInput.getText().toString().trim();


                if (!"".equals(hdlctext)){
                    if (!"".equals(ldlctext)){
                        if (!"".equals(triglyceridestext)){
                            if (!"".equals(cholestroltext)){

                                    hdlc = Double.parseDouble(hdlctext);
                                    ldlc = Double.parseDouble(ldlctext);
                                    triglycerides = Double.parseDouble(triglyceridestext);
                                    cholestrol = Double.parseDouble(cholestroltext);


                                    Intent intent = new Intent(ManualCholesterolTestActivity.this, CBCTestResultActivity.class);
                                    intent.putExtra("HDL-C", hdlc);
                                    intent.putExtra("LDL-C", ldlc);
                                    intent.putExtra("Triglycerides", triglycerides);
                                    intent.putExtra("Cholestrol", cholestrol);
                                    intent.putExtra("Sex", gender);
                                    intent.putExtra("Age", age);
                                    startActivity(intent);

                            }else {
                                Toast.makeText(ManualCholesterolTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(ManualCholesterolTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(ManualCholesterolTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ManualCholesterolTestActivity.this, "الرجاء ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}