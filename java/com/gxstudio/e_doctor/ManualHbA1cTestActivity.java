package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManualHbA1cTestActivity extends AppCompatActivity {
    EditText Percent;
    Double percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_hb_a1c_test);

        Percent = findViewById(R.id.hba1cPercentEditText);
        TextView resultBtn = (TextView) findViewById(R.id.resultBtnHbA1cManualPage);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String percentText = Percent.getText().toString().trim();
                if (!"".equals(percentText)){
                    percent = Double.parseDouble(percentText);
                    Intent intent = new Intent(ManualHbA1cTestActivity.this, HbA1cTestResultActivity.class);
                    intent.putExtra("Percent", percent);
                    intent.putExtra("Method","manual");
                    startActivity(intent);
                } else {
                    Toast.makeText(ManualHbA1cTestActivity.this, "الرجاء ادخال نسبة الفحص", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}