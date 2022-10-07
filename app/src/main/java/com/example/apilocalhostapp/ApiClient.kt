package com.example.apilocalhostapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun create(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl("http://192.168.157.54:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build().
            create(ApiInterface::class.java)
    }
}