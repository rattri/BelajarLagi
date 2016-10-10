package com.solfashop.fragment;

/**
 * Created by Ratri on 10/5/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.solfashop.API.Interfaces.LoginService;
import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.model.ServerRequest;
import com.solfashop.model.ServerResponse;
import com.solfashop.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginFragment extends BaseFragment implements View.OnClickListener{

    private AppCompatButton btn_login;
    private EditText et_email,et_password;
    private TextView tv_register,tv_reset_password;
    private ProgressBar progress;
    private SharedPreferences pref;
    TextView textHome;
    String message;
    Button btnHome, btnOrder, btnPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        baseActivity = (BaseActivity) getActivity();
//          ]
//        btnHome = (Button) v.findViewById(R.id.btn_home);
//        btnOrder = (Button) v.findViewById(R.id.btn_order);
//        btnPrice = (Button) v.findViewById(R.id.btn_price);
//        textHome.setText(message);
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/
        initViews(view);
        setTitle("Login");
        return view;
    }

    public static LoginFragment newInstance(String message) {
        LoginFragment fragment = new LoginFragment();
        fragment.message = message;
        return fragment;
    }


    private void initViews(View view){

//        pref = getActivity().getPreferences(0);
        pref = getActivity().getSharedPreferences(BaseActivity.LOGIN_OPERATION, Context.MODE_PRIVATE);

        btn_login = (AppCompatButton)view.findViewById(R.id.btn_login);
        tv_register = (TextView)view.findViewById(R.id.tv_register);
        tv_reset_password = (TextView)view.findViewById(R.id.tv_reset_password);
        et_email = (EditText)view.findViewById(R.id.et_email);
        et_password = (EditText)view.findViewById(R.id.et_password);

        progress = (ProgressBar)view.findViewById(R.id.progress);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_reset_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

//
            case R.id.tv_register:
//                goToRegister();
//                break;
            case R.id.btn_login:
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()) {

                    progress.setVisibility(View.VISIBLE);
                    loginProcess(email,password);

                } else {

                    Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
                }
                break;
//            case R.id.tv_reset_password:
//                goToResetPassword();
//                break;
        }
    }
    private void loginProcess(String email,String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(BaseActivity.LOGIN_OPERATION);
        request.setUser(user);
        Call<ServerResponse> response = loginService.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {

                ServerResponse resp = response.body();
                Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();

                if(resp.getResult().equals(BaseActivity.SUCCESS)){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean(BaseActivity.IS_LOGGED_IN,true);
                    editor.putString(BaseActivity.EMAIL,resp.getUser().getEmail());
                    editor.putString(BaseActivity.NAME,resp.getUser().getName());
                    editor.putString(BaseActivity.UNIQUE_ID,resp.getUser().getUnique_id());
                    editor.apply();
                    goToMain ();

                }
                progress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progress.setVisibility(View.INVISIBLE);
                Log.d(BaseActivity.TAG,"failed");
                Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();

            }
        });
    }

//    private void goToResetPassword(){
//
//        Fragment reset = new ResetPasswordFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_frame,reset);
//        ft.commit();
//    }

//    private void goToRegister(){
//
//        Fragment register = new RegisterFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_frame,register);
//        ft.commit();
//    }

//    private void goToProfile(){
//
//        Fragment profile = new ProfileFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_frame,profile);
//        ft.commit();
//    }
    private void goToMain (){
        Intent i = new Intent(getActivity(),  ActivityMain.class);
        startActivity(i);
    }
}
