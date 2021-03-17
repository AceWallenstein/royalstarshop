package com.pinnoocle.royalstarshop.nets;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.BuildConfig;
import com.pinnoocle.royalstarshop.utils.FastData;

import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by whs on 2017/2/17
 * Retrofit 初始化
 */


public class RetrofitHelper {
    private Context mContext;

    public NetworkMonitor networkMonitor;
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);

        }
        return instance;
    }

    private RetrofitHelper(Context mContext) {
        this.mContext = mContext;
        networkMonitor = new LiveNetworkMonitor(mContext);
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addNetworkInterceptor(new MyNetworkInterceptor());
        okHttpClientBuilder.addInterceptor(new UrlInterceptor());
        //5秒超时
        okHttpClientBuilder.connectTimeout(20, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://gsyp.vtui365.com/")
                .client(client().build())
                //.addConverterFactory(SimpleXmlConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

//    private OkHttpClient.Builder getClient() {
//        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
//        //add log record
//        if (BuildConfig.DEBUG) {
//            //打印网络请求日志
//            LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
//                    .loggable(BuildConfig.DEBUG)
//                    .setLevel(Level.BASIC)
//                    .log(Platform.INFO)
//                    .request("请求")
//                    .response("响应")
//                    .build();
//            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
////            httpClientBuilder.addInterceptor(new TokenInterceptor(mContext));
//        }
//        return httpClientBuilder;
//    }

    public static OkHttpClient.Builder client() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        httpClientBuilder.proxy(Proxy.NO_PROXY);


        httpClientBuilder.addInterceptor(
                new HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                )
        );

        return httpClientBuilder;
    }


    private class MyNetworkInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            if (networkMonitor.isConnected()) {
                Log.d("requestUrl", chain.request().url().toString());
                return chain.proceed(chain.request());
            } else {
                //throw new NoNetworkException();
                ToastUtils.showToast("无网络连接，请检查网络");
            }
            return null;
        }
    }

    private class UrlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Log.i("requestUrl", chain.request().url().toString());
            return chain.proceed(chain.request());
        }
    }

    /**
     * 常规接口
     *
     * @return
     */
    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }

}
