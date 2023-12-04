package com.example.andersenretrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiClient @Inject constructor() {
    val apiClient = Retrofit.Builder()
        .baseUrl("https://api.coincap.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
