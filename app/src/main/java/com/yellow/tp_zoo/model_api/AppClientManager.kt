package com.yellow.tp_zoo.model_api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()
    private var path = ""

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}