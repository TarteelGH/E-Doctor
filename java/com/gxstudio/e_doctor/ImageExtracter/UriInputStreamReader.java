package com.gxstudio.e_doctor.ImageExtracter;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;

public class UriInputStreamReader {

    public static InputStream getInputStreamFromUri(Context context, Uri uri) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver.openInputStream(uri);
    }
}
