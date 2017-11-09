package com.piyanutinukson.rmutsvservice.utillity;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by lenovo on 9/11/2560.
 */

public class DeletData extends AsyncTask<String,Void,String> {

    private Context context;

    public DeletData(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... strings) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "trur")
                    .add("Name", strings[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[1]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return null;
    }
} // Main Class
