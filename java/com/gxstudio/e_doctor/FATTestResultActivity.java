package com.gxstudio.e_doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
public class FATTestResultActivity extends AppCompatActivity {
    TextView hdlcResult, ldlcResult, triglyceridesResult, cholesterolResult;
    String gender;
    Integer age;
    Double hdlc, ldlc, triglycerides, cholesterol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_lfttest_result);

        gender = getIntent().getStringExtra("Sex");
        age = getIntent().getIntExtra("Age", 0);

        hdlc = getIntent().getDoubleExtra("HDL-C", 0);
        ldlc = getIntent().getDoubleExtra("LDL-C", 0);
        triglycerides = getIntent().getDoubleExtra("Triglycerides", 0);
        cholesterol = getIntent().getDoubleExtra("Cholesterol", 0);

        hdlcResult = findViewById(R.id.hdlcResult);
        ldlcResult = findViewById(R.id.ldlcResult);
        triglyceridesResult = findViewById(R.id.triglyceridesResult);
        cholesterolResult = findViewById(R.id.cholesterolResult);


        if (gender.equals("Male")) {
            // Interpretation logic for HDL-C in males
            if (hdlc >= 40 && hdlc <= 65) {
                hdlcResult.setText("نتيجة HDL-C طبيعية\n"+" إذ أن ذلك يقلل من خطر الإصابة بأمراض القلب لديك\n");
                hdlcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (hdlc < 40) {
                hdlcResult.setText("نتيجة HDL-C منخفضة\n"+"أسباب انخفاض قراءة تحليل البروتين الشحمي مرتفع الكثافة\n" +
                        "زيادة الوزن\n" +
                        "التدخين\n" +
                        "عوامل وراثية\n" +
                        "التغذية السليمة\n" +
                        "قلة الحركة\n");
                hdlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                hdlcResult.setText("نتيجة HDL-C مرتفعة\n"+"أسباب ارتفاع قراءة تحليل البروتين الشحمي مرتفع الكثافة\n" +
                        "ادمان الكحول\n" +
                        "rosuvastatin\n" +
                        "امراض الغدة الدرقية\n" +
                        "التهابات\n" +
                        "اوميغا 3\n" );
                hdlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for LDL-C in males
            if (ldlc >= 50 && ldlc <= 170) {
                ldlcResult.setText("نتيجة LDL-C طبيعية\n");
                ldlcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ldlc > 170) {
                ldlcResult.setText("نتيجة LDL-C مرتفعة\n"+"أسباب ارتفاع قراءة تحليل البروتين الشحمي منخفض الكثافة\n" +
                        "تدخين\n" +
                        "سكري الحمل\n" +
                        "امراض الكلى\n" +
                        "التدخين\n" +
                        "متلازمة نقص المناعة المكتسبة\n" +
                        "السمنة\n" +
                        "الوراثة\n" +
                        "قلة الحركة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                ldlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                ldlcResult.setText("نتيجة LDL-C منخفضة\n"+"نتيجتك أقل بقليل من المعدل الطبيعي، ينصح بمراجعة الطبيب.\n"+"أسباب انخفاض قراءة تحليل البروتين الشحمي منخفض الكثافة\n" +
                        "مرض وراثي\n" );
                ldlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for triglycerides in males
            if (triglycerides >= 40 && triglycerides <= 160) {
                triglyceridesResult.setText("نتيجة Triglycerides طبيعية\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (triglycerides > 160) {
                triglyceridesResult.setText("نتيجة Triglycerides مرتفعة\n"+"أسباب ارتفاع قراءة تحليل الدهون الثلاثية\n" +
                        "سكري\n" +
                        "امراض الكلى\n" +
                        "مثبطات بيتا\n" +
                        "ادمان الكحول\n" +
                        "السمنة\n" +
                        "الاستروجين\n" +
                        "حبوب تنظيم النسل\n" +
                        "تاموكسيفين\n" +
                        "كسل الغدة الدرقية\n" +
                        "أسبرين\n" +
                        "مدرات البول\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                triglyceridesResult.setText("نتيجة Triglycerides منخفضة\n"+"أسباب انخفاض قراءة تحليل الدهون الثلاثية\n" +
                        "أوميغا\n" +
                        "سوء تغذية\n" +
                        "rosuvastatin\n" +
                        "الصيام\n" +
                        "طعام صحي\n" +
                        "فرط نشاط الغدة الدرقية\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for total cholesterol in males
            if (cholesterol >= 70 && cholesterol <= 200) {
                cholesterolResult.setText("نتيجة Cholesterol طبيعية\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (cholesterol > 200) {
                cholesterolResult.setText("نتيجة Cholesterol مرتفعة\n"+"أسباب ارتفاع قراءة تحليل الكوليسترول\n" +
                        "حمل\n" +
                        "ارتفاع الكوليستيرول\n" +
                        "الوراثة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                cholesterolResult.setText("نتيجة Cholesterol منخفضة\n"+"أسباب ارتفاع قراءة تحليل الكوليسترول\n" +
                        "حمل\n" +
                        "ارتفاع الكوليستيرول\n" +
                        "الوراثة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

        } else if (gender.equals("Female")) {
            // Interpretation logic for HDL-C in females
            if (hdlc >= 50 && hdlc <= 75) {
                hdlcResult.setText("نتيجة HDL-C طبيعية\n"+" إذ أن ذلك يقلل من خطر الإصابة بأمراض القلب لديك\n");
                hdlcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (hdlc < 50) {
                hdlcResult.setText("نتيجة HDL-C منخفضة\n"+"أسباب انخفاض قراءة تحليل البروتين الشحمي مرتفع الكثافة\n" +
                        "زيادة الوزن\n" +
                        "التدخين\n" +
                        "عوامل وراثية\n" +
                        "التغذية السليمة\n" +
                        "قلة الحركة\n");
                hdlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                hdlcResult.setText("نتيجة HDL-C مرتفعة\n"+"أسباب ارتفاع قراءة تحليل البروتين الشحمي مرتفع الكثافة\n" +
                        "ادمان الكحول\n" +
                        "rosuvastatin\n" +
                        "امراض الغدة الدرقية\n" +
                        "التهابات\n" +
                        "اوميغا 3\n" );
                hdlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for LDL-C in females
            if (ldlc >= 35 && ldlc <= 135) {
                ldlcResult.setText("نتيجة LDL-C طبيعية\n");
                ldlcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ldlc > 135) {
                ldlcResult.setText("نتيجة LDL-C مرتفعة\n"+"أسباب ارتفاع قراءة تحليل البروتين الشحمي منخفض الكثافة\n" +
                        "تدخين\n" +
                        "سكري الحمل\n" +
                        "امراض الكلى\n" +
                        "التدخين\n" +
                        "متلازمة نقص المناعة المكتسبة\n" +
                        "السمنة\n" +
                        "الوراثة\n" +
                        "قلة الحركة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                ldlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                ldlcResult.setText("نتيجة LDL-C منخفضة\n"+"نتيجتك أقل بقليل من المعدل الطبيعي، ينصح بمراجعة الطبيب.\n"+"أسباب انخفاض قراءة تحليل البروتين الشحمي منخفض الكثافة\n" +
                        "مرض وراثي\n" );
                ldlcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for triglycerides in females
            if (triglycerides >= 40 && triglycerides <= 160) {
                triglyceridesResult.setText("نتيجة Triglycerides طبيعية\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (triglycerides > 160) {
                triglyceridesResult.setText("نتيجة Triglycerides مرتفعة\n"+"أسباب ارتفاع قراءة تحليل الدهون الثلاثية\n" +
                        "سكري\n" +
                        "امراض الكلى\n" +
                        "مثبطات بيتا\n" +
                        "ادمان الكحول\n" +
                        "السمنة\n" +
                        "الاستروجين\n" +
                        "حبوب تنظيم النسل\n" +
                        "تاموكسيفين\n" +
                        "كسل الغدة الدرقية\n" +
                        "أسبرين\n" +
                        "مدرات البول\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                triglyceridesResult.setText("نتيجة Triglycerides منخفضة\n"+"أسباب انخفاض قراءة تحليل الدهون الثلاثية\n" +
                        "أوميغا\n" +
                        "سوء تغذية\n" +
                        "rosuvastatin\n" +
                        "الصيام\n" +
                        "طعام صحي\n" +
                        "فرط نشاط الغدة الدرقية\n");
                triglyceridesResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }

            // Interpretation logic for total cholesterol in females
            if (cholesterol >= 70 && cholesterol <= 200) {
                cholesterolResult.setText("نتيجة Cholesterol طبيعية\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (cholesterol > 200) {
                cholesterolResult.setText("نتيجة Cholesterol مرتفعة\n"+"أسباب ارتفاع قراءة تحليل الكوليسترول\n" +
                        "حمل\n" +
                        "ارتفاع الكوليستيرول\n" +
                        "الوراثة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            } else {
                cholesterolResult.setText("نتيجة Cholesterol منخفضة\n"+"أسباب ارتفاع قراءة تحليل الكوليسترول\n" +
                        "حمل\n" +
                        "ارتفاع الكوليستيرول\n" +
                        "الوراثة\n" +
                        "اتباع نظام غذائي غير صحي غني بالدهون\n");
                cholesterolResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));

            }
        }

    }
}




