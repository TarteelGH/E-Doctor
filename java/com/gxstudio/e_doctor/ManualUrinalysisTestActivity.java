package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ManualUrinalysisTestActivity extends AppCompatActivity {

    Spinner spinnerColor, spinnerAspect, spinnerPH, spinnerProtein, spinnerGlocose, spinnerNitrite, spinnerBlood, spinnerBilirubin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_urinalysis_test);

        spinnerColor = findViewById(R.id.spinner_color);
        spinnerAspect = findViewById(R.id.spinner_aspect);
        spinnerPH = findViewById(R.id.spinner_ph);
        spinnerProtein = findViewById(R.id.spinner_protein);
        spinnerGlocose = findViewById(R.id.spinner_glocose);
        spinnerNitrite = findViewById(R.id.spinner_nitrite);
        spinnerBlood = findViewById(R.id.spinner_blood);
        spinnerBilirubin = findViewById(R.id.spinner_bilirubin);



        // drop down list for Color
        ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this, R.array.Color, android.R.layout.simple_spinner_item);
        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerColor.setAdapter(adapterColors);

        // drop down list for Aspect
        ArrayAdapter<CharSequence> adapterAspect = ArrayAdapter.createFromResource(this, R.array.Aspect, android.R.layout.simple_spinner_item);
        adapterAspect.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerAspect.setAdapter(adapterAspect);

        // drop down list for PH
        ArrayAdapter<CharSequence> adapterPH = ArrayAdapter.createFromResource(this, R.array.PH, android.R.layout.simple_spinner_item);
        adapterPH.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPH.setAdapter(adapterPH);

        // drop down list for Protein
        ArrayAdapter<CharSequence> adapterProtein = ArrayAdapter.createFromResource(this, R.array.Protein, android.R.layout.simple_spinner_item);
        adapterProtein.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerProtein.setAdapter(adapterProtein);

        // drop down list for Glocose
        ArrayAdapter<CharSequence> adapterGlocose = ArrayAdapter.createFromResource(this, R.array.Glocose, android.R.layout.simple_spinner_item);
        adapterGlocose.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGlocose.setAdapter(adapterGlocose);

        // drop down list for Glocose
        ArrayAdapter<CharSequence> adapterBilirubin = ArrayAdapter.createFromResource(this, R.array.Bilirubin, android.R.layout.simple_spinner_item);
        adapterBilirubin.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerBilirubin.setAdapter(adapterBilirubin);

        // drop down list for Nitrite
        ArrayAdapter<CharSequence> adapterNitrite = ArrayAdapter.createFromResource(this, R.array.Nitrite, android.R.layout.simple_spinner_item);
        adapterNitrite.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerNitrite.setAdapter(adapterNitrite);

        // drop down list for Blood
        ArrayAdapter<CharSequence> adapterBlood = ArrayAdapter.createFromResource(this, R.array.Blood, android.R.layout.simple_spinner_item);
        adapterBlood.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerBlood.setAdapter(adapterBlood);
    }
}