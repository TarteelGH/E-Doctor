package com.gxstudio.e_doctor;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.view.View;

import android.view.View;

public class SocialMedia extends AppCompatActivity {

    ImageView ivWhatsapp , ivFacebook , ivInstagram , ivGmail  ;
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        ivWhatsapp = findViewById(R.id.iv_whats);
        ivFacebook = findViewById(R.id.iv_face);
        ivGmail = findViewById(R.id.iv_gmail);
        ivInstagram = findViewById(R.id.iv_insta);

        ivWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sNumber = "+972 59-840-3483";
                Uri uri = Uri.parse(String.format(
                        "https://api.whatsapp.com/send?phone=%s",sNumber
                ));

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sAppLink = "https://www.facebook.com/profile.php?id=100094656793886";

                openLink(sAppLink);

            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String sAppLink = "https://www.instagram.com/e.doctor_app/";
                  openLink(sAppLink);
            }
        });

        ivGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = "e.doctor.contact@gmail.com";
                Uri uri = Uri.parse(emailAddress);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });

    }

    private void openLink(String sAppLink) {
        try{
            Uri uri =Uri.parse(sAppLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }catch (ActivityNotFoundException activityNotFoundException){

            Uri uri =Uri.parse(sAppLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}
