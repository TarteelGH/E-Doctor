package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class HbA1cTestResultActivity extends AppCompatActivity {

    Double percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hb_a1c_test_result);

        TextView resultText = (TextView) findViewById(R.id.hba1cResultText);
        TextView aboutTestBtn = (TextView) findViewById(R.id.aboutHbA1cTestBtnPage);

        String method = getIntent().getStringExtra("Method");
        Toast.makeText(this, method, Toast.LENGTH_SHORT).show();
        if (Objects.equals(method, "studio")){
            percent = getIntent().getDoubleExtra("extractedNumber",0.0);
            Toast.makeText(this, percent.toString(), Toast.LENGTH_SHORT).show();

        }else if (Objects.equals(method, "camera")){
            percent = getIntent().getDoubleExtra("extractedNumber",0.0);
            Toast.makeText(this, percent.toString(), Toast.LENGTH_SHORT).show();

        }else {
            percent = getIntent().getDoubleExtra("Percent",0.0);
            Toast.makeText(this, percent.toString(), Toast.LENGTH_SHORT).show();
        }

        if (0.0 <= percent && percent <= 5.9 ){
            resultText.setText("تدل القراءة أن النتيجة طبييعة ، ويجدر الذكر أن القيمة الطبيعية لدى مرضى السكري هي أقل من 7%");
        } else if (6.0 <= percent && percent <= 6.4) {
            resultText.setText("نتيجتك أعلى بقليل من المعدل الطبيعي، وينصح باستشارة الطبيب، حيث تدل نتيجتك على أنك مصاب بمقدمات السكري، ويجدر الذكر أن القيمة الطبيعية لدى مرضى السكري هي أقل من 7%");
        } else if (percent >= 6.5) {
            resultText.setText("نتيجتك أعلى من المعدل الطبيعي، وينصح باستشارة الطبيب، حيث تدل نتيجتك أنك مصاب بالسكري من النوع الثاني، ويجدر الذكر أن القيمة الطبيعية لدى مرضى السكري هي أقل من 7%");
        }

        aboutTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HbA1cTestResultActivity.this, AboutHbA1cTestActivity.class);
                startActivity(intent);
            }
        });
    }
}