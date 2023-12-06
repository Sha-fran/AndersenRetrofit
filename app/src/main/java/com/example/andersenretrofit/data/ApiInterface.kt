package com.example.andersenretrofit.data

import com.example.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET(Constants.END_POINT_CRYPTO)
    suspend fun getCryptoByName(@Path("cryptoName")name:String): Response<CurrencyResponse>
}
