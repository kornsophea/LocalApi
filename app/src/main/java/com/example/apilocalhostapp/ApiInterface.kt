package com.example.apilocalhostapp

import android.telecom.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("/user")
    fun postDataApi(@Body data: ApiData ):retrofit2.Call<ApiData>

    @GET("/user")
    fun getDataApi():retrofit2.Call<List<ApiData>>

    @DELETE("/user/{id}")
    fun deleteDataApi(@Path("id") id:Int):retrofit2.Call<Void>
}