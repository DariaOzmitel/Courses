package com.example.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object ApiFactory {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/DariaOzmitel/c075b05d98b7d974645b1e60e07f8535/raw/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}