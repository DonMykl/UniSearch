package com.donmykl.unisearch.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    //a singleton object instance of the retrofit library which is used to make api calls
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

    }
}