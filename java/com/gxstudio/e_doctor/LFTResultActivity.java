package com.gxstudio.e_doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
public class LFTResultActivity extends AppCompatActivity {
    TextView altResult, aptResult, astResult, ggtResult, tbiliResult, globulinResult;
    String gender;
    Integer age;
    Double alt, apt, ast, ggt, tbili, globulin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lft_result);

        gender = getIntent().getStringExtra("Sex");
        age = getIntent().getIntExtra("Age", 0);

        alt = getIntent().getDoubleExtra("ALT", 0);
        apt = getIntent().getDoubleExtra("APT", 0);
        ast = getIntent().getDoubleExtra("AST", 0);
        ggt = getIntent().getDoubleExtra("GGT", 0);
        tbili = getIntent().getDoubleExtra("T.BILI", 0);
        globulin = getIntent().getDoubleExtra("Globulin", 0);

        altResult = findViewById(R.id.altResult);
        aptResult = findViewById(R.id.aptResult);
        astResult = findViewById(R.id.astResult);
        ggtResult = findViewById(R.id.ggtResult);
        tbiliResult = findViewById(R.id.tbiliResult);
        globulinResult = findViewById(R.id.globulinResult);


        if (gender.equals("Male")) {
            // Interpretation logic for ALT, APT, AST, GGT, TBILi, and Globulin in males
            if (alt >= 29 && alt <= 33) {
                altResult.setText("نتيجة ALT طبيعية\n");
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (alt > 33) {
                altResult.setText("نتيجة ALT مرتفعة\n"+"نتيجتك أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل ALT على التهاب الكبد، أو تشمع الكبد أو وجود سرطان الكبد، أو موت أنسجة الكبد، أو قلة تدفق الدم ووصوله إلى الكبد، أو أي من أمراض الكبد الأخرى\n" +"أسباب ارتفاع قراءة تحليل أنزيم ناقلة امين ألانين\n" +
                        "أدوية\n" +
                        "فيتامينات\n" +
                        "التهاب الكبد\n" +
                        "سرطان الكبد\n" +
                        "تليف الكبد\n" );
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                altResult.setText("نتيجة ALT منخفضة\n"+"تعد النتيجة أقل من المستوى الطبييعي وينصح الفرد باستشارة الطبيب\n");
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (apt >= 44 && apt <= 147) {
                aptResult.setText("نتيجة APT طبيعية\n");
                aptResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style2));


            } else if (apt > 70) {
                aptResult.setText("نتيجة APT مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم الفسفاتاز القلوية\n" +
                        "تشمع الكبد\n" +
                        "سرطان العظم\n" +
                        "التهاب المرارة\n" +
                        "سرطان الكبد\n" +
                        "تلف الكبد\n" +
                        "سرطان الغدد الليمفاوية\n" +
                        "انسداد القناة الصفراوية\n" +
                        "مرض باجيت\n" +
                        "فشل القلب الاحتقاني\n" );
                aptResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            } else {
                aptResult.setText("نتيجة APT منخفضة\n"+"أسباب انخفاض قراءة تحليل أنزيم الفسفاتاز القلوية\n" +
                        "سوء التغذية\n" +
                        "نقص الزنك\n" +
                        "نقص الفوسفات\n" );
                aptResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (ast >= 8 && ast <= 48) {
                astResult.setText("نتيجة AST طبيعية\n");
                astResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ast > 48) {
                astResult.setText("نتيجة AST مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم ناقلة أمين الأسبارتات\n" +
                        "أدوية\n" +
                        "فيتامينات\n" +
                        "حروق\n" +
                        "امراض العضلات\n" +
                        "نوبات القلبية\n" +
                        "سرطان الكبد\n" +
                        "تدمير خلايا الدم الحمراء\n" +
                        "نليف الكبد\n" );
                astResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            } else {
                astResult.setText("نتيجة AST منخفضة\n"+"نتيجة التحليل أقل من المستوى الطبيعي وينصح الفرد باستشارة الطبيب\n"
                );
                astResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (ggt >= 5 && ggt <= 40) {
                ggtResult.setText("نتيجة GGT طبيعية\n");
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ggt > 40) {
                ggtResult.setText("نتيجة GGT مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم ناقلة الغاما غلوتاميل\n" +
                        "التهاب البنكرياس\n" +
                        "السكري\n" +
                        "سكتة قلبية\n" +
                        "تليف الكبد\n" +
                        "التهاب الكبد الفيروسي\n" +
                        "الإفراط في تناول الكحول\n" +
                        "ورم الكبد\n" +
                        "مرض الكبد الدهني\n" +
                        "استخدام أدوية\n" );
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                ggtResult.setText("نتيجة GGT منخفضة\n"+"أسباب انخفاض قراءة تحليل أنزيم ناقلة الغاما غلوتاميل\n" +
                        "الحمل\n" +
                        "قصور الغدة الدرقية\n" +
                        "نقص المغنيسيوم\n" +
                        "نقص فيتامين ب6\n");
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            }

            if (tbili >= 0.3 && tbili <= 1.2) {
                tbiliResult.setText("نتيجة TBILi طبيعية\n");
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (tbili > 1.2) {
                tbiliResult.setText("نتيجة TBILi مرتفعة\n");
                tbiliResult.setText("أسباب ارتفاع قراءة تحليل البيليروبين الكلي في الدم\n" +
                        "التهاب الكبد\n" +
                        "شرب الكحول\n" +
                        "سرطان البنكرياس\n" +
                        "حصى المرارة\n" +
                        "تليف الكبد\n" +
                        "سرطان المرارة\n" +
                        "انسداد القنوات الصفراوية\n" +
                        ":اقرا المزيد من خلال موقع الطبي\n"
                );
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                tbiliResult.setText("نتيجة TBILi منخفضة\n");
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (globulin >= 2 && globulin <= 3.5) {
                globulinResult.setText("نتيجة Globulin طبيعية\n");
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            }
            else if (globulin > 3.5) {
                globulinResult.setText("نتيجة Globulin مرتفعة\n"+
                        "قد تشير المستويات المرتفعة إلى العدوى أو الأمراض الالتهابية أو الاضطرابات المناعية. قد تشير مستويات الجلوبيولين المرتفعة أيضًا إلى أنواع معينة من السرطان، مثل الورم النقيي المتعدد أو مرض هودجكين أو سرطان الغدد الليمفاوية الخبيث.\n"
                );
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else  if (globulin < 2) {
                globulinResult.setText("نتيجة Globulin منخفضة\n"+"يمكن أن تكون مستويات الجلوبيولين المنخفضة علامة على مرض في الكبد أو في الكلى.\n"
                );
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

        } else if (gender.equals("Female")) {
            // Interpretation logic for ALT, APT, AST, GGT, TBILi, and Globulin in females
            if (alt >= 19 && alt <= 25) {
                altResult.setText("نتيجة ALT طبيعية\n");
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (alt > 36) {
                altResult.setText("نتيجة ALT مرتفعة\n"+"نتيجتك أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل ALT على التهاب الكبد، أو تشمع الكبد أو وجود سرطان الكبد، أو موت أنسجة الكبد، أو قلة تدفق الدم ووصوله إلى الكبد، أو أي من أمراض الكبد الأخرى\n" +"أسباب ارتفاع قراءة تحليل أنزيم ناقلة امين ألانين\n" +
                        "أدوية\n" +
                        "فيتامينات\n" +
                        "التهاب الكبد\n" +
                        "سرطان الكبد\n" +
                        "تليف الكبد\n" );
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                altResult.setText("نتيجة ALT منخفضة\n"+"تعد النتيجة أقل من المستوى الطبييعي وينصح الفرد باستشارة الطبيب\n");
                altResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (apt >= 44 && apt <= 147) {
                aptResult.setText("نتيجة APT طبيعية\n");
                aptResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style2));


            } else if (apt > 70) {
                aptResult.setText("نتيجة APT مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم الفسفاتاز القلوية\n" +
                        "تشمع الكبد\n" +
                        "سرطان العظم\n" +
                        "التهاب المرارة\n" +
                        "سرطان الكبد\n" +
                        "تلف الكبد\n" +
                        "سرطان الغدد الليمفاوية\n" +
                        "انسداد القناة الصفراوية\n" +
                        "مرض باجيت\n" +
                        "فشل القلب الاحتقاني\n" );
                aptResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            } else {
                aptResult.setText("نتيجة APT منخفضة\n"+"أسباب انخفاض قراءة تحليل أنزيم الفسفاتاز القلوية\n" +
                        "سوء التغذية\n" +
                        "نقص الزنك\n" +
                        "نقص الفوسفات\n" );
                aptResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (ast >= 7 && ast <= 45) {
                astResult.setText("نتيجة AST طبيعية\n");
                aptResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ast > 45) {
                astResult.setText("نتيجة AST مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم ناقلة أمين الأسبارتات\n" +
                        "أدوية\n" +
                        "فيتامينات\n" +
                        "حروق\n" +
                        "امراض العضلات\n" +
                        "نوبات القلبية\n" +
                        "سرطان الكبد\n" +
                        "تدمير خلايا الدم الحمراء\n" +
                        "نليف الكبد\n" );
                astResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            } else {
                astResult.setText("نتيجة AST منخفضة\n"+"نتيجة التحليل أقل من المستوى الطبيعي وينصح الفرد باستشارة الطبيب\n"
                );
                astResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (ggt >= 5 && ggt <= 40) {
                ggtResult.setText("نتيجة GGT طبيعية\n");
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (ggt > 40) {
                ggtResult.setText("نتيجة GGT مرتفعة\n"+"أسباب ارتفاع قراءة تحليل أنزيم ناقلة الغاما غلوتاميل\n" +
                        "التهاب البنكرياس\n" +
                        "السكري\n" +
                        "سكتة قلبية\n" +
                        "تليف الكبد\n" +
                        "التهاب الكبد الفيروسي\n" +
                        "الإفراط في تناول الكحول\n" +
                        "ورم الكبد\n" +
                        "مرض الكبد الدهني\n" +
                        "استخدام أدوية\n" );
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                ggtResult.setText("نتيجة GGT منخفضة\n"+"أسباب انخفاض قراءة تحليل أنزيم ناقلة الغاما غلوتاميل\n" +
                        "الحمل\n" +
                        "قصور الغدة الدرقية\n" +
                        "نقص المغنيسيوم\n" +
                        "نقص فيتامين ب6\n");
                ggtResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));


            }

            if (tbili >= 0.3 && tbili <= 1.2) {
                tbiliResult.setText("نتيجة TBILi طبيعية\n");
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            } else if (tbili > 1.2) {
                tbiliResult.setText("نتيجة TBILi مرتفعة\n");
                tbiliResult.setText("أسباب ارتفاع قراءة تحليل البيليروبين الكلي في الدم\n" +
                        "التهاب الكبد\n" +
                        "شرب الكحول\n" +
                        "سرطان البنكرياس\n" +
                        "حصى المرارة\n" +
                        "تليف الكبد\n" +
                        "سرطان المرارة\n" +
                        "انسداد القنوات الصفراوية\n" +
                        ":اقرا المزيد من خلال موقع الطبي\n"
                );
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else {
                tbiliResult.setText("نتيجة TBILi منخفضة\n");
                tbiliResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (globulin >= 2 && globulin <= 3.5) {
                globulinResult.setText("نتيجة Globulin طبيعية\n");
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));

            }
            else if (globulin > 3.5) {
                globulinResult.setText("نتيجة Globulin مرتفعة\n"+
                        "قد تشير المستويات المرتفعة إلى العدوى أو الأمراض الالتهابية أو الاضطرابات المناعية. قد تشير مستويات الجلوبيولين المرتفعة أيضًا إلى أنواع معينة من السرطان، مثل الورم النقيي المتعدد أو مرض هودجكين أو سرطان الغدد الليمفاوية الخبيث.\n"
                );
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            } else  if (globulin < 2) {
                globulinResult.setText("نتيجة Globulin منخفضة\n"+"يمكن أن تكون مستويات الجلوبيولين المنخفضة علامة على مرض في الكبد أو في الكلى.\n"
                );
                globulinResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }
        }

    }
}

