package com.dupleit.demo.kotlintest.Network

import com.dupleit.demo.kotlintest.SignupModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by mandeep on 9/11/17.
 */
interface ApiService {

    @FormUrlEncoded
    @POST("checkUserSignup_request")
    abstract fun checkEmails(@Field("USER_EMAIL") email: String, @Field("USER_PASSWORD") password: String, @Field("USER_NAME") name: String, @Field("USER_MOBILE") userMobile: String): Call<SignupModel>

}