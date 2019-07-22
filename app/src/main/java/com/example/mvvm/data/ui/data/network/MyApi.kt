package com.example.mvvm.data.ui.data.network

import com.example.mvvm.data.ui.data.network.responses.AuthResponse
import com.example.mvvm.data.ui.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("userlogin")
    suspend fun userLogin(
    @Field("email") email: String,
    @Field("password") password: String
    ) : Response<AuthResponse>

    @FormUrlEncoded
    @POST("createuser")
    suspend fun userSignUp(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String

    ): Response<AuthResponse>

    @GET("allquotes")
    suspend fun getQuotes() : Response<QuotesResponse>

    companion object{
        operator fun invoke(
             networkConnectionInterceptor : NetworkConnectionInterceptor
        ) : MyApi{

            val okkHttpClient = OkHttpClient.Builder()
                .addInterceptor( networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okkHttpClient)
                .baseUrl("http://172.20.10.4/MyApi/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi ::class.java)
        }
    }

}