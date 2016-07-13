package demo.acfun.com.acfundemo.network;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import demo.acfun.com.acfundemo.model.TuiJianEntity;
import demo.acfun.com.acfundemo.model.WelComeEntity;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chen on 16/6/20.
 */
public class AppHttp {

    public static String BASE_URL = "http://api.aixifan.com/";

    public static AppHttp appHttp;
    private static Retrofit retrofit;
    public static RetrofitApi retrofitApi;
    private static OkHttpClient client;

    public interface AppHttpCallBack {
        void returnEntity(Object object, boolean isFromCache, Request request, Response response);
    }


    /**
     * apphttp 单例
     */
    public static AppHttp getInstance() {
        if (appHttp == null) {
            appHttp = new AppHttp();
        }
        return appHttp;
    }

    /**
     * retrofit 单例
     */
    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            if (client == null) {
                client = new OkHttpClient.Builder()
                        .addInterceptor(new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request()
                                        .newBuilder()
                                        .addHeader("User-agent", "acvideo core")
                                        .addHeader("productId", "2000")
                                        .addHeader("deviceType", "1")
                                        .addHeader("uid", "0")
                                        .addHeader("appVersion", "4.1.8")
                                        .addHeader("resolution", "1080x1776")
                                        .addHeader("udid", "9627719a-6aa9-383b-bf57-ccdc2b12bd8e")
                                        .addHeader("Host", "api.aixifan.com")
                                        .addHeader("market", "tencent")
                                        .addHeader("Connection", "Keep-Alive")
                                        .addHeader("Accept-Encoding", "gzip")
                                        .build();
                                return chain.proceed(request);
                            }

                        })
                        .build();
            }
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

    /**
     * retrofitapi inteface 单例
     */
    public static RetrofitApi getRetrofitApi() {
        if (retrofitApi == null) {
            retrofitApi = getRetrofit().create(RetrofitApi.class);
        }

        return retrofitApi;
    }


    public interface RetrofitApi {
        /**
         *主页 数据
         */
        @GET("regions?")
        Observable<TuiJianEntity> getTuijian(@Query("belong") String belong, @Query("loadCount") String loadCount);

        /**
         * 欢迎页面 图片
         */
        @GET("flashScreens/{getFlashScreen}")
        Observable<WelComeEntity> getWelCome(@Path("getFlashScreen") String getFlashScreen);


    }


}
