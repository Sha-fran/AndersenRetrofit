package com.example.andersenretrofit.domain

class GetCurrencyByNameUseCase(private val getCurrency: GetCurrencyRepository) {
    suspend fun getCurrencyByName(name: String) {
        getCurrency.getCurrencyByName(name)
    }
}
