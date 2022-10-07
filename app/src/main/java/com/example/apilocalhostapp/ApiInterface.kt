package com.example.apilocalhostapp

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("/user")
    fun postDataApi(@Body data: ApiData ):retrofit2.Call<ApiData>

    @GET("/user")
    fun getDataApi():retrofit2.Call<List<ApiData>>
}