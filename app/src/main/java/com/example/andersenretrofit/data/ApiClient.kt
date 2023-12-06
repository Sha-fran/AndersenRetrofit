package com.example.andersenretrofit.data

import android.provider.SyncStateContract.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiClient @Inject constructor() {
    val apiClient = Retrofit.Builder()
        .baseUrl(com.example.util.Constants.API_CRYPTO)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
