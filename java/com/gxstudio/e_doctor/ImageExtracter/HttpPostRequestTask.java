package com.gxstudio.e_doctor.ImageExtracter;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class HttpPostRequestTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = "HttpPostRequestTask";
    private final String serverUrl;
    private final File fileToUpload;

    private static String result;

    public HttpPostRequestTask(String serverUrl, File fileToUpload) {
        this.serverUrl = serverUrl;
        this.fileToUpload = fileToUpload;
    }

    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient.Builder()
                .hostnameVerifier((hostname, session) -> true) // Bypass SSL verification (not recommended for production)
                .build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("document", fileToUpload.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), fileToUpload))
                .build();

        Request request = new Request.Builder()
                .url(serverUrl)
                .post(requestBody)
                .addHeader("Authorization", "Token 24d02613b89564e7437f4fa393ec07a2") // Add Authorization header
                .addHeader("Content-Type", "multipart/form-data") // Add Content-Type header
//                .addHeader("Content-Type", "application/json") // Add Content-Type header
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                Log.e(TAG, "Request failed: " + response.code() + " " + response.message());
                Log.e(TAG, String.valueOf(response));

                return null;
            }
        } catch (IOException e) {
            Log.e(TAG, "Error making POST request: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            // Handle the response here
            Log.d(TAG, "Response: " + result);

            // Set the 'result' as the static field
            HttpPostRequestTask.result = result;

            String mainString = result;

            int indexContent = mainString.indexOf("\"content\": ");
            int indexContentEnd = mainString.indexOf(",",indexContent + 1);

            String content = mainString.substring(indexContent,indexContentEnd);

            if (indexContent != -1) {
                System.out.println("Substring : " + content);

                String[] parts = content.split(":"); // Split the input by colon

                if (parts.length >= 2) {
                    String numberPart = parts[1].trim(); // Get the second part and remove leading/trailing spaces
                    numberPart = numberPart.replaceAll("[\" ]", ""); // Remove double quotes and spaces
                    double extractedNumber = Double.parseDouble(numberPart); // Parse the number as a double

                    System.out.println("Extracted number: " + extractedNumber);

                }
            } else {
                System.out.println("Substring not found");
            }


        } else {
            // Handle the error
            Log.e(TAG, "Error in POST request");
        }
    }

    // Create a getter method to access the 'result'
    public static String getResult() {
        return result;
    }

}
