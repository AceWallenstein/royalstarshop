package com.pinnoocle.royalstarshop.nets;

import android.content.Intent;

import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.login.LoginActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {


        Request request = chain.request();
        Response response = chain.proceed(request);

        ResponseBody responseBody = response.body();
        if (responseBody != null) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            try {
                String result = buffer.clone().readString(StandardCharsets.UTF_8);
                JSONObject jsonObject = new JSONObject(result);
                int code = jsonObject.getInt("code");
                if (code == -1) {
                    Intent intent = new Intent(MyApp.getInstance(), LoginActivity.class);
                    MyApp.getInstance().startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }


}