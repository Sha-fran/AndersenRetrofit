package com.example.andersenretrofit.domain

import com.example.andersenretrofit.data.CurrencyResponse
import retrofit2.Response

interface GetCurrencyRepository {
    suspend fun getCurrencyByName(name: String): Response<CurrencyResponse>
}
