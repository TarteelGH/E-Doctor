package com.gxstudio.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gxstudio.e_doctor.ImageExtracter.HttpPostRequestTask;

import java.io.File;

public class
TestPaperActivity extends AppCompatActivity {

    private static String SERVER_URL = null; // Replace with your server URL
    private static String apiName = null;
    ImageView imageView;
    TextView sacnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paper);

        String method = getIntent().getStringExtra("Method");
        String filePath = getIntent().getStringExtra("FilePath");
        Integer age = getIntent().getIntExtra("Age",0);
        String gender = getIntent().getStringExtra("Sex");
        String testType = getIntent().getStringExtra("TestType");

        imageView = findViewById(R.id.imageCapture);
        sacnBtn = findViewById(R.id.sacnBtn);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (method.equals("studio")){
                    Uri uri = Uri.parse(getIntent().getStringExtra("imageUri"));
                    imageView.setImageURI(uri);
                }

                if (method.equals("camera")){
                    Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("imageBitmap");
                    imageView.setImageBitmap(bitmap);
                }
            }
        },500);

        sacnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (testType.equals("HbA1c")) {
                    apiName = "hb_aic_test";
                    SERVER_URL = "https://api.mindee.net/v1/products/Saifoo/" + apiName + "/v1/predict";

                    // Create an instance of HttpPostRequestTask and execute it
                    File fileToUpload = new File(filePath);
                    HttpPostRequestTask httpPostRequestTask = new HttpPostRequestTask(SERVER_URL, fileToUpload);
                    httpPostRequestTask.execute();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String globalResult = HttpPostRequestTask.getResult();
                            System.out.println("Result : " + globalResult);

                            String mainString = globalResult;

                            if (globalResult != null){
                                int indexContent = mainString.indexOf("\"content\": ");
                                int indexContentEnd = mainString.indexOf(",",indexContent + 1);

                                String content = mainString.substring(indexContent,indexContentEnd);

                                if (indexContent != -1) {

                                    String[] parts = content.split(":"); // Split the input by colon

                                    if (parts.length >= 2) {
                                        String numberPart = parts[1].trim(); // Get the second part and remove leading/trailing spaces
                                        numberPart = numberPart.replaceAll("[\" ]", ""); // Remove double quotes and spaces
                                        double extractedNumber = Double.parseDouble(numberPart); // Parse the number as a double

                                        System.out.println("Extracted number: " + extractedNumber);

                                        Intent intent = new Intent(TestPaperActivity.this,HbA1cTestResultActivity.class);
                                        intent.putExtra("extractedNumber",extractedNumber);
                                        intent.putExtra("Method",method);
                                        startActivity(intent);

                                    }
                                } else {
                                    System.out.println("Substring not found");
                                }
                            }else {
                                Log.e("Result","null");
                            }
                        }
                    },3000);


                } else if (testType.equals("CBC")) {
                    apiName = "cbc_test_all";
                    SERVER_URL = "https://api.mindee.net/v1/products/Saifoo/" + apiName + "/v1/predict";

                    // Create an instance of HttpPostRequestTask and execute it
                    File fileToUpload = new File(filePath);
                    HttpPostRequestTask httpPostRequestTask = new HttpPostRequestTask(SERVER_URL, fileToUpload);
                    httpPostRequestTask.execute();
                    String globalResult = HttpPostRequestTask.getResult();
                    System.out.println("Result" + globalResult);
                }
            }

        });

    }
}