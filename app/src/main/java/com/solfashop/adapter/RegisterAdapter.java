package com.solfashop.adapter;

import android.content.Context;

import com.google.gson.Gson;
import com.solfashop.API.Interfaces.CheckoutService;
import com.solfashop.API.Interfaces.RegisterService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.API.form.CheckoutForm;
import com.solfashop.API.form.RegisterForm;
import com.solfashop.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/22/2016.
 */
public class RegisterAdapter {
    Context context;
    BaseActivity activity;
    RegisterForm mRegisterForm;


    public RegisterAdapter(BaseActivity activity, RegisterForm registerForm){
        context = activity.getBaseContext();
        this.activity = activity;
        mRegisterForm = registerForm;

    }

    public void initData(){
        System.out.println(mRegisterForm.getUsername());

        RegisterService registerService = ServiceGenerator.testCnc(RegisterService.class);
        Call<RegisterForm> registerResponseCall = registerService.getRegisterResponse(mRegisterForm);
        registerResponseCall.enqueue(new Callback<RegisterForm>() {
            @Override
            public void onResponse(Call<RegisterForm> call, Response<RegisterForm> response) {
                if(response.isSuccess()){

                    System.out.println("....................sukses");
                    System.out.println(response.raw().toString());
                    System.out.println(new Gson().toJson(response.body()));
                }
                else System.out.println("....................else");
            }

            @Override
            public void onFailure(Call<RegisterForm> call, Throwable t) {
                System.out.println("...................."+t.toString());
            }
        });
    }
}
