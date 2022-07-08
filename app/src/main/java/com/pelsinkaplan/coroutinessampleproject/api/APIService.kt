package com.pelsinkaplan.coroutinessampleproject.api

import com.pelsinkaplan.coroutinessampleproject.data.Coffee
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/coffee/hot")
    fun getHotCoffee(): Call<List<Coffee>>

    @GET("/coffee/iced")
    fun getColdCoffee(): Call<List<Coffee>>
}