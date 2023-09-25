package com.donmykl.unisearch.interfaces

import com.donmykl.unisearch.model.University
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    //An api interface where the requests are defined
    @GET("/search")
    suspend fun getUniData() : Response<List<University>>

}