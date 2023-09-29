package com.gxstudio.e_doctor;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.gxstudio.e_doctor.ImageExtracter.BitmapToUriConverter;
import com.gxstudio.e_doctor.ImageExtracter.GetFilePath;
import com.gxstudio.e_doctor.ImageExtracter.HttpPostRequestTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import java.io.File;
import java.io.IOException;

public class ScanMethodActivity extends AppCompatActivity {

    int PERMISSION_ALL = 1;

    private static String FILE_PATH = null ; // Replace with the path to your file

    String[] PERMISSIONS = {
            android.Manifest.permission.CAMERA,
            Manifest.permission.READ_MEDIA_IMAGES,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.INTERNET,
    };

    private static final int PICK_IMAGE_REQUEST = 10;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private int STORAGE_PERMISSION_CODE = 1;

    ImageView manualBtn, studioBtn, cameraBtn;

    Uri selectedImageUri;

    String testType, gender, ageText, method;
    Integer age;

    Boolean onTick = false;

    private PreviewView previewView;
    private ImageCapture imageCapture;

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_method);

        testType = getIntent().getStringExtra("TestType");

        manualBtn = findViewById(R.id.manualBtn);
        studioBtn = findViewById(R.id.studioBtn);
        cameraBtn = findViewById(R.id.cameraBtn);

        gender = getIntent().getStringExtra("Sex");
        ageText = getIntent().getStringExtra("Age");
        age = Integer.parseInt(ageText);


        manualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testType.equals("CBC")){
                    Intent intent = new Intent(ScanMethodActivity.this, ManualCBCTestActivity.class);
                    intent.putExtra("Age",age);
                    intent.putExtra("Sex",gender);
                    startActivity(intent);

                }else if (testType.equals("Cholesterol")) {
                    Intent intent = new Intent(ScanMethodActivity.this, ManualCholesterolTestActivity.class);
                    startActivity(intent);
                }else if (testType.equals("LFT")) {
                    Intent intent = new Intent(ScanMethodActivity.this, ManualLFTTestActivity.class);
                    startActivity(intent);
                }else if (testType.equals("Urinalysis")) {
                    Intent intent = new Intent(ScanMethodActivity.this, ManualUrinalysisTestActivity.class);
                    startActivity(intent);
                }else if (testType.equals("HbA1c")){
                    Intent intent = new Intent(ScanMethodActivity.this, ManualHbA1cTestActivity.class);
                    intent.putExtra("Method","manual");
                    startActivity(intent);
                }
            }
        });

        //

        studioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasPermissions(ScanMethodActivity.this, PERMISSIONS)) {
                    ActivityCompat.requestPermissions(ScanMethodActivity.this, PERMISSIONS, PERMISSION_ALL);
                }else {
                    pickImage();
                }
                onTick = true;
                method = "Studio";

            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!hasPermissions(ScanMethodActivity.this, PERMISSIONS)) {
                    ActivityCompat.requestPermissions(ScanMethodActivity.this, PERMISSIONS, PERMISSION_ALL);
                }else {
                    openCamera();
                }
                onTick = true;
                method = "Camera";
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST && data != null) {
                // Handle image selected from gallery
                selectedImageUri = data.getData();

                Log.d("selectedImageUri : ", selectedImageUri.getPath());

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            FILE_PATH = GetFilePath.processImage(selectedImageUri, ScanMethodActivity.this);

                        } catch (IOException e) {
                            Log.e("processImage", e.getMessage());
                            throw new RuntimeException(e);
                        }

                        Intent intent = new Intent(ScanMethodActivity.this,TestPaperActivity.class);
                        intent.putExtra("FilePath",FILE_PATH);
                        intent.putExtra("Method", "studio");
                        intent.putExtra("imageUri",selectedImageUri.toString());
                        intent.putExtra("Age",age);
                        intent.putExtra("Sex",gender);
                        intent.putExtra("TestType",testType);
                        startActivity(intent);
                    }
                },100);

            } else if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                // Handle photo taken from the camera
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                selectedImageUri = BitmapToUriConverter.convertBitmapToUri(this, imageBitmap);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("selectedImageUri : ", selectedImageUri.getPath());

                        try {
                            FILE_PATH = GetFilePath.processImage(selectedImageUri, ScanMethodActivity.this);

                        } catch (IOException e) {
                            Log.e("processImage", e.getMessage());
                            throw new RuntimeException(e);
                        }

                        Intent intentCam = new Intent(ScanMethodActivity.this,TestPaperActivity.class);
                        intentCam.putExtra("FilePath",FILE_PATH);
                        intentCam.putExtra("Method", "camera");
                        intentCam.putExtra("imageBitmap", imageBitmap);
                        intentCam.putExtra("Age",age);
                        intentCam.putExtra("Sex",gender);
                        intentCam.putExtra("TestType",testType);
                        startActivity(intentCam);
                    }
                },100);

            }
        }
    }

    private void pickImage() {
        if (!hasPermissions(ScanMethodActivity.this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(ScanMethodActivity.this, PERMISSIONS, PERMISSION_ALL);
        }

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    public void openCamera() {
        if (!hasPermissions(ScanMethodActivity.this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(ScanMethodActivity.this, PERMISSIONS, PERMISSION_ALL);
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    public void openStudio(){
        pickImage();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "permissions granted", Toast.LENGTH_SHORT).show();

                if (method == "Studio" && onTick == true){
                    openStudio();
                    onTick = false;

                }else if (method == "Camera" && onTick == true){
                    onTick = false;
                    openCamera();
                }

            }else {
                Toast.makeText(this, "permissions denied", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.fromParts("package", getPackageName(), null));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }


}