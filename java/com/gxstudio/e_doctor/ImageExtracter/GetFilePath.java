package com.gxstudio.e_doctor.ImageExtracter;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.mindee.input.LocalInputSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GetFilePath {
    public static String processImage(Uri filePath, Context context) throws IOException {

        String selectedFilePath = null;

        InputStream inputStream = null;
        try {
            inputStream = UriInputStreamReader.getInputStreamFromUri(context, filePath);

            // Use the inputStream for reading data or any other operations.
            // For example, you can read the content of the file.
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions, such as file not found or permission issues.
        }


//        InputStream inputStream = GalleryFileReader.readFileFromGallery(context, filePath);

        if (inputStream != null) {
            Log.d("inputStream : ", String.valueOf(inputStream));
            LocalInputSource inputSource = new LocalInputSource(inputStream, "sdsdf.jpg");
            // Use the inputStream to read the file contents
            // For example, you can read the image and display it.


            selectedFilePath = FilePath.getPath(context, filePath);
            // Load a file from disk
            Log.i("selectedFilePath", selectedFilePath);
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                // External storage is available, proceed with file access
                LocalInputSource inputSource2 = new LocalInputSource(new File(selectedFilePath));

            } else {
                // Handle the case where the file couldn't be opened
                return "Error :" + filePath;
            }

        }

        return selectedFilePath;
    }
}
