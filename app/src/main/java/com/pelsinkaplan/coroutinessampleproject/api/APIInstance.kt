package com.pelsinkaplan.coroutinessampleproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIInstance {
    private const val BASE_URL = "https://api.sampleapis.com/"
    private var retrofit: Retrofit? = null

    fun getInstance(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit as Retrofit
    }
}