package com.example.andersenretrofit.data

import com.example.andersenretrofit.domain.GetCurrencyRepository
import retrofit2.Response

class GetCurrencyRepositoryImpl(private val client: ApiClient) : GetCurrencyRepository {
    private val apiInterface = client.apiClient.create(ApiInterface::class.java)

    override suspend fun getCurrencyByName(name: String): Response<CurrencyResponse> =
        apiInterface.getCryptoByName(name)
}
