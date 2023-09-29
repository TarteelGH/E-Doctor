package com.gxstudio.e_doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class CBCTestResultActivity extends AppCompatActivity {
    
    TextView rbcResult, wbcResult, hgbResult, hctResult, pltResult;
    String gender;
    Integer age;
    Double rbc,wbc,hgb,hct,plt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbctest_result);
        
        gender = getIntent().getStringExtra("Sex");
        age = getIntent().getIntExtra("Age",0);

        rbc = getIntent().getDoubleExtra("RBC",0);
        wbc = getIntent().getDoubleExtra("WBC",0);
        hgb = getIntent().getDoubleExtra("HGB",0);
        hct = getIntent().getDoubleExtra("HCT",0);
        plt = getIntent().getDoubleExtra("PLT",0);

        rbcResult = findViewById(R.id.rbcResult);
        wbcResult = findViewById(R.id.wbcResult);
        hgbResult = findViewById(R.id.hgbResult);
        hctResult = findViewById(R.id.hctResult);
        pltResult = findViewById(R.id.pltResult);
        
        
        if (gender.equals("Male")){
            if(rbc >= 4.7 && rbc <= 6.1){
                rbcResult.setText("نتيجة كريات الدم الحمراء طبيعيية");
                rbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
            }
            else if(rbc > 6.1) {
                rbcResult.setText("نتيجة كريات الدم الحمراء أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب للمساعدة في تفسير نتائج التحليل، كما أن نتائج القراءة تختلف من فرد إلى آخر باختلاف العمر، والتاريخ الصحي، والجنس، كما توجد بعض العوامل الأخرى التي تؤثر على القراءة، مثل الجفاف، أو التوتر ومن المحتمل أن تكون ممارسا أو حاملا لإحدى هذه الحالات المرضية : \n" +
                        "جفاف\n" +
                        "التدخين\n" +
                        "امراض الرئة\n" +
                        "عوامل وراثية\n" +
                        "سرطان الكلية\n" +
                        "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                        "أمراض القلب الخلقية .\n");
                rbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));
            }

            if (age >= 13){ // HGB for young people
                if (hgb >= 14 && hgb <= 18){
                    hgbResult.setText("نتيجة الهيموغلبين طبيعية");
                    hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
                }
                else if (hgb > 18) {
                    hgbResult.setText("نتيجة الهيموغلبين أعلى من المعدل الطبيعي ينصح باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل Hgb على الإصابة ببعض الحالات الطبية مثل \n" +
                            "أمراض الكلى \n" +
                            "التدخين \n" +
                            "امراض الرئة\n" +
                            "الجفاف\n" +
                            "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                            "أمراض القلب الخلقية\n" +
                            "أورام الكلى\n" +
                            "داء الانسداد الرئوي المزمن. )");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                } else if (hgb < 14) {
                    hgbResult.setText("نتيجة الهيموغلبين أقل من المعدل الطبيعي ينصح باستشارة الطبيب، وقد تدل انخفاض القراءة على بعض الحالات الطبية مثل \n" +
                            "فقر الدم المنجلي  \n" +
                            "فقر الدم الانحلال\n" +
                            "القرحة\n" +
                            "سوء التغذية فقر الدم المنجلي \n" +
                            "قصور الدرقية\n" +
                            "الاورام الحميدة\n" +
                            "نقص الحديد\n" +
                            "ثلاسيميا\n" +
                            "نقص حمض الفوليك\n" +
                            "الفشل الكلوي\n" +
                            "النزيف المزمن\n" +
                            "نزيف الحيض الغزير\n" +
                            "اضطرابات نخاع العظم\n" +
                            ")\n");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                }

            }else if (age <= 12 && age > 2){ // HGB for child
                if (hgb >= 11 && hgb <= 14){
                    hgbResult.setText("نتيجة الهيموغلبين طبيعية");
                    hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
                }
                else if (hgb > 14) {
                    hgbResult.setText("نتيجة الهيموغلبين أعلى من المعدل الطبيعي ينصح باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل Hgb على الإصابة ببعض الحالات الطبية مثل \n" +
                            "أمراض الكلى \n" +
                            "التدخين \n" +
                            "امراض الرئة\n" +
                            "الجفاف\n" +
                            "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                            "أمراض القلب الخلقية\n" +
                            "أورام الكلى\n" +
                            "داء الانسداد الرئوي المزمن. )");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                }else if (hgb < 11){
                    hgbResult.setText("نتيجة الهيموغلبين أقل من المعدل الطبيعي ينصح باستشارة الطبيب، وقد تدل انخفاض القراءة على بعض الحالات الطبية مثل \n" +
                            "فقر الدم المنجلي  \n" +
                            "فقر الدم الانحلال\n" +
                            "القرحة\n" +
                            "سوء التغذية فقر الدم المنجلي \n" +
                            "قصور الدرقية\n" +
                            "الاورام الحميدة\n" +
                            "نقص الحديد\n" +
                            "ثلاسيميا\n" +
                            "نقص حمض الفوليك\n" +
                            "الفشل الكلوي\n" +
                            "النزيف المزمن\n" +
                            "نزيف الحيض الغزير\n" +
                            "اضطرابات نخاع العظم\n" +
                            ")\n");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                }

            } else if (age == 2 || age == 1) { // HGB for baby
                if (hgb >= 12 && hgb <= 16){
                    hgbResult.setText("نتيجة الهيموغلبين طبيعية");
                    hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
                } else if (hgb > 18) {
                    hgbResult.setText("نتيجة الهيموغلبين أعلى من المعدل الطبيعي ينصح باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل Hgb على الإصابة ببعض الحالات الطبية مثل \n" +
                            "أمراض الكلى \n" +
                            "التدخين \n" +
                            "امراض الرئة\n" +
                            "الجفاف\n" +
                            "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                            "أمراض القلب الخلقية\n" +
                            "أورام الكلى\n" +
                            "داء الانسداد الرئوي المزمن. )");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                } else if (hgb < 11) {
                    hgbResult.setText("نتيجة الهيموغلبين أقل من المعدل الطبيعي ينصح باستشارة الطبيب، وقد تدل انخفاض القراءة على بعض الحالات الطبية مثل \n" +
                            "فقر الدم المنجلي  \n" +
                            "فقر الدم الانحلال\n" +
                            "القرحة\n" +
                            "سوء التغذية فقر الدم المنجلي \n" +
                            "قصور الدرقية\n" +
                            "الاورام الحميدة\n" +
                            "نقص الحديد\n" +
                            "ثلاسيميا\n" +
                            "نقص حمض الفوليك\n" +
                            "الفشل الكلوي\n" +
                            "النزيف المزمن\n" +
                            "نزيف الحيض الغزير\n" +
                            "اضطرابات نخاع العظم\n" +
                            ")\n");
                    hgbResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
                }

            }

            if (hct >= 42 && hct <= 52){
                hctResult.setText("نتيجة hct طبيعية");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style2));
            }
            else if (hct > 52) {
                hctResult.setText("نتيجة hct أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب، وقد يدل ذلك على الجفاف والذي يعد السبب الرئيسي لارتفاع مستويات الهيماتوكريت، كما قد يدل ذلك على \n" +
                        "كثرة الكريات الحمراء الحقيقة\n" +
                        "أمراض القلب الخلقية\n" +
                        "أمراض الرئة \n" +
                        "سرطان الكلى )\n");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
            }
            else if (hct < 42) {
                hctResult.setText("نتيجة hct أقل من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب نتيجتك وقد يدل ذلك على \n" +
                        "إصابة الفقر الدم\n" +
                        "أمراض الكلى \n" +
                        "نقص التغذية في الحديد أو فيتامين ب 12\n" +
                        "حمض الفوليك،\n" +
                        "وجود مرض في نخاع العظم\n" +
                        "إصابة الفرد ببعض أنواع السرطان مثل سرطان الدم )\n");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
            }

        } else if (gender.equals("Female")) {
            if(rbc >= 4.2 && rbc <= 5.4){
                rbcResult.setText("نتيجة كريات الدم الحمراء أقل من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب للمساعدة في تفسير نتائج التحليل، كما أن نتائج القراءة تختلف من فرد إلى آخر باختلاف العمر، والتاريخ الصحي، والجنس، كما توجد بعض العوامل الأخرى التي تؤثر على القراءة، مثل الجفاف، أو التوتر ومن المحتمل أن تكون ممارسا أو حاملا لإحدى هذه الحالات المرضية : \n" +
                        "سرطان القولون\n" +
                        "فقر الدم المنجلي\n" +
                        "فشل كلوي\n" +
                        "نقص الحديد\n" +
                        "فقر الدم الانحلالي\n" +
                        "نزيف القناة الهضمية\n" +
                        "نقص حمض الفوليك\n" +
                        "نقص فيتامين ب 12\n" +
                        "لمفومة\n" +
                        "الثلاسيميا\n" +
                        "تلف نخاع العظم\n" +
                        "القرحة\n" +
                        "نقص انزيم G6PD\n" +
                        "مشكلة في نخاع العظم\n");
                rbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }else if (rbc > 5.4){
                rbcResult.setText("نتيجتك أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب للمساعدة في تفسير نتائج التحليل، كما أن نتائج القراءة تختلف من فرد إلى آخر باختلاف العمر، والتاريخ الصحي، والجنس، كما توجد بعض العوامل الأخرى التي تؤثر على القراءة، مثل الجفاف، أو التوتر ومن المحتمل أن تكون ممارسا أو حاملا لإحدى هذه الحالات المرضية : \n" +
                        "جفاف\n" +
                        "التدخين\n" +
                        "امراض الرئة\n" +
                        "عوامل وراثية\n" +
                        "سرطان الكلية\n" +
                        "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                        "أمراض القلب الخلقية .\n");
                rbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
            }

            if (hgb >= 12 && hgb <= 16){
                hgbResult.setText("نتيجة الهيموغلبين طبيعية");
                hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
            }
            else if (hgb > 16) {
                hgbResult.setText("نتيجة الهيموغلبين أعلى من المعدل الطبيعي ينصح باستشارة الطبيب، وقد يدل ارتفاع قراءة تحليل Hgb على الإصابة ببعض الحالات الطبية مثل \n" +
                        "أمراض الكلى \n" +
                        "التدخين \n" +
                        "امراض الرئة\n" +
                        "الجفاف\n" +
                        "كَثْرَةُ الحُمْرِ الحَقيقِيَّة\n" +
                        "أمراض القلب الخلقية\n" +
                        "أورام الكلى\n" +
                        "داء الانسداد الرئوي المزمن. ) ");
                hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));
            }
            else if (hgb < 12) {
                hgbResult.setText("النتيجة أقل من المعدل الطبيعي ينصح باستشارة الطبيب، وقد تدل انخفاض القراءة على بعض الحالات الطبية مثل \n" +
                        "فقر الدم المنجلي  \n" +
                        "فقر الدم الانحلال\n" +
                        "القرحة\n" +
                        "سوء التغذية فقر الدم المنجلي \n" +
                        "قصور الدرقية\n" +
                        "الاورام الحميدة\n" +
                        "نقص الحديد\n" +
                        "ثلاسيميا\n" +
                        "نقص حمض الفوليك\n" +
                        "الفشل الكلوي\n" +
                        "النزيف المزمن\n" +
                        "نزيف الحيض الغزير\n" +
                        "اضطرابات نخاع العظم\n" +
                        ")\n");
                hgbResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));

            }

            if (hct >= 37 && hct <= 47){
                hctResult.setText("نتيجة hct طبيعية");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style2));
            }
            else if (hct > 47) {
                hctResult.setText("نتيجة hct أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب، وقد يدل ذلك على الجفاف والذي يعد السبب الرئيسي لارتفاع مستويات الهيماتوكريت، كما قد يدل ذلك على \n" +
                        "كثرة الكريات الحمراء الحقيقة\n" +
                        "أمراض القلب الخلقية\n" +
                        "أمراض الرئة \n" +
                        "سرطان الكلى )\n");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
            }
            else if (hct < 37) {
                hctResult.setText("نتيجة hct أقل من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب نتيجتك وقد يدل ذلك على \n" +
                        "إصابة الفقر الدم\n" +
                        "أمراض الكلى \n" +
                        "نقص التغذية في الحديد أو فيتامين ب 12\n" +
                        "حمض الفوليك،\n" +
                        "وجود مرض في نخاع العظم\n" +
                        "إصابة الفرد ببعض أنواع السرطان مثل سرطان الدم )\n");
                hctResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
            }
        }

        if(wbc >= 4.8 && wbc <= 11){
            wbcResult.setText("نتيجة كريات الدم البيضاء طبيعية");
            wbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style2));
        }
        else if (wbc < 4.8) {
            wbcResult.setText("نتيجتك أقل من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب للمساعدة في تفسير نتائج التحليل، كما أن نتائج القراءة تختلف من فرد إلى آخر باختلاف العمر، والتاريخ الصحي، والجنس، كما توجد بعض العوامل الأخرى التي تؤثر على القراءة، مثل الجفاف، أو التوتر ومن المحتمل أن تكون ممارسا أو حاملا لإحدى هذه الحالات المرضية : \n" +
                    "ايدز\n" +
                    "تعفن الدم\n" +
                    "كلوزابين\n" +
                    "جابنتين\n" +
                    "لمفومة\n" +
                    "مرض المناعة الذاتية\n" +
                    "تلف نخاع العظم\n");
            wbcResult.setBackground(ContextCompat.getDrawable(this, R.drawable.comment_background_style));
        } else if (wbc > 11) {
            wbcResult.setText("نتيجتك أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب للمساعدة في تفسير نتائج التحليل، كما أن نتائج القراءة تختلف من فرد إلى آخر باختلاف العمر، والتاريخ الصحي، والجنس، كما توجد بعض العوامل الأخرى التي تؤثر على القراءة، مثل الجفاف، أو التوتر ومن المحتمل أن تكون ممارسا أو حاملا لإحدى هذه الحالات المرضية :\n" +
                    "ربو\n" +
                    "حساسية\n" +
                    "التهاب\n" +
                    "سرطان الدم\n" +
                    "عدوى\n" +
                    "ابنفرين\n" +
                    "التوتر العاطفي والفيزيائي الشديد\n" +
                    "الشهر الأخير من الحمل\n" +
                    "فيلغراستين )\n");
            wbcResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
        }

        if (plt >= 150000 && plt <= 4000000){
            pltResult.setText("نتيجة plt طبيعية");
            pltResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style2));
        }
        else if (plt > 4000000) {
            pltResult.setText("نتيجة plt أعلى من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب إذ أن الأفراد الذين يعانون من ارتفاع عدد الصفائح الدموية معرضون لخطر تكون الجلطات الدموية، أو النزيف الشديد أو لأن يصابو بأي حالة مرضية من الحالات الآتية : أسباب ارتفاع قراءة تحليل تعداد صفائح الدم\n" +
                    "سرطان المبيض\n" +
                    "سرطان الثدي\n" +
                    "سرطان المعدة\n" +
                    "مرض السل\n" +
                    "التهاب المفاصل الروماتويدي\n" +
                    "فقر الدم الانحلالي\n" +
                    "داء الامعاء الالتهابي\n" +
                    "اسئصال الطحال )\n");
            pltResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
        } else if (plt < 150000) {
            pltResult.setText("نتيجتك أقل من المعدل الطبيعي، وينصح الفرد باستشارة الطبيب إذ أن الأفراد الذين يكون لديهم نقص في الصفائح، ويعانون من نقص الصفائح الدموية، فإنهم عندما يصابون بكدمات أو جروح ويكون النزيف لديهم أكثر خطورة ومعرضون للإصابة بالعديد من الحالات المرضية الخطيرة مثل : \n" +
                    "سرطان الدم.\n" +
                    "أمراض المناعة الذاتية.\n" +
                    "الأدوية التي تؤثر على إنتاج الصفائح الدموية.\n" +
                    "نقص فيتامين ك.\n" +
                    "نقص الحديد.\n" +
                    "نقص حمض الفوليك )\n");
            pltResult.setBackground(ContextCompat.getDrawable(this,R.drawable.comment_background_style));
        }

    }
}