package com.solfashop.API.Interfaces;

import com.solfashop.model.ServerRequest;
import com.solfashop.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ratri on 10/5/2016.
 */
public interface LoginService {
    @POST("login-register/")
    Call<ServerResponse> operation(@Body ServerRequest request);
}
