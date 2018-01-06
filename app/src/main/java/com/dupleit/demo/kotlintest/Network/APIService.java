package com.dupleit.demo.kotlintest.Network;

import com.dupleit.demo.kotlintest.SignupModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface APIService {
    @FormUrlEncoded
    @POST("checkUserSignup_request")
    Call<SignupModel> checkEmails(@Field("USER_EMAIL") String email, @Field("USER_PASSWORD") String password, @Field("USER_NAME") String name, @Field("USER_MOBILE") String userMobile);


}