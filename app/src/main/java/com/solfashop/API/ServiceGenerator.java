package com.solfashop.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RetryableSink;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ratri on 10/3/2016.
 */
public class ServiceGenerator {

    public static final String baseUrl = "http://solfadev.net/api/vouchershop/";
    public static <T> T connect(Class<T> service){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder requestBuilder = request.newBuilder();
                        requestBuilder.method(request.method(), request.body());
                        Response response = chain.proceed(requestBuilder.build());
                        return response;
                    }
                }).build();
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public static <T> T testCnc(Class<T> service){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder requestBuilder = request.newBuilder();
                        requestBuilder.method(request.method(), request.body());
//                        if (auth){
//                            if(type == AUTH_USER){
//                                // TODO : ini masih belum jalan, masih fatal exception
//                                try{
//                                    requestBuilder.header("Authorization", Data.UserData.getId());
//                                } catch (Exception e){
//
//                                }
//                            }
//                        }
                        Response response = chain.proceed(requestBuilder.build());
                        return response;
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

}
