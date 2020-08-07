package com.yellow.tp_zoo.model_api

import retrofit2.Call
import retrofit2.http.GET

class ApiZooVenue {
    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()
    public fun getData() {

        val apiService = AppClientManager.client.create(ApiService::class.java
                apiService.index().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                val sb = StringBuffer()
                val list = response.body()
                for (p in list!!) {
                    sb.append(p.body)
                    sb.append("\n")
                    sb.append("---------------------\n")
                }
                tv._text_ = sb.toString()
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }
        })
    }
}

interface ApiService {
    @GET("/posts")
    fun index(): Call<List<Posts>>
}
