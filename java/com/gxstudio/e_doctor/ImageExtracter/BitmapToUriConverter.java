package com.gxstudio.e_doctor.ImageExtracter;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapToUriConverter {

    public static Uri convertBitmapToUri(Context context, Bitmap bitmap) {
        // Create a unique file name for the saved image
        String fileName = "image_" + System.currentTimeMillis() + ".png";

        // Create a directory for storing the image
        ContextWrapper contextWrapper = new ContextWrapper(context);
        File directory = contextWrapper.getDir("images", Context.MODE_PRIVATE);

        // Create a file object to represent the saved image
        File imageFile = new File(directory, fileName);

        try {
            // Create an output stream and save the bitmap to the file
            FileOutputStream fos = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Error occurred while saving the image
        }

        // Get a Uri from the file
        return Uri.fromFile(imageFile);
    }

}
