package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class readabouthetest  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_method);

         Button ReadBtn = findViewById(R.id.ReadBtn);

        ReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine the type of test (e.g., by some condition or user input)
                String testType = /* Get the test type from your source, e.g., user input or condition */;

                // Check the test type and open the corresponding activity or layout
                if ("urine_a1c".equals(testType)) {
                    // Open the activity_about_urine_a1c_test.xml or related activity
                    Intent intent = new Intent(readabouthetest.this,AboutHbA1cTestActivity.class);
                    startActivity(intent);
                } else if ("lft_a1c".equals(testType)) {
                    // Open the activity_about_lft_a1c_test.xml or related activity
                    Intent intent = new Intent(readabouthetest.this,AboutHbA1cTestActivity.class);
                    startActivity(intent);
                } else if ("hb_a1c".equals(testType)) {
                    // Open the activity_about_hb_a1c_test.xml or related activity
                    Intent intent = new Intent(readabouthetest.this,AboutHbA1cTestActivity.class);
                    startActivity(intent);
                } else if ("fat_ac1".equals(testType)) {
                    // Open the activity_about_fat_ac1_test.xml or related activity
                    Intent intent = new Intent(readabouthetest.this,AboutHbA1cTestActivity.class);
                    startActivity(intent);
                } else if ("cbc_a1c".equals(testType)) {
                    // Open the activity_about_cbc_a1c_test.xml or related activity
                    Intent intent = new Intent(readabouthetest.this, AboutHbA1cTestActivity.class);
                    startActivity(intent);

                }
            }
        });
    }

}
