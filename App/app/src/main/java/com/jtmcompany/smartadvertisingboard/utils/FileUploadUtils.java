package com.jtmcompany.smartadvertisingboard.utils;

import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// 제작한광고를 서버에 파일업로드하는부분(OK HTTP 사용)
public class FileUploadUtils {
    static final String SERVER_URL="http://112.154.171.27:5000";
    public static void sendServer(File file){
        RequestBody requestBody=new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("files",file.getName(), RequestBody.create(MultipartBody.FORM,file))
                .build();
        Request request=new Request.Builder()
                .url(SERVER_URL)
                .post(requestBody)
                .build();

        OkHttpClient client=new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("tak55","에러");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            Log.d("tak55",response.body().string());
            Log.d("tak55","동영상 업로드 완료");

            }
        });

    }
}
