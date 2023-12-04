package com.example.andersenretrofit.domain

import javax.inject.Inject

class GetCurrencyByNameUseCase @Inject constructor(private val getCurrency: GetCurrencyRepository) {
    suspend fun getCurrencyByName(name: String) = getCurrency.getCurrencyByName(name)
}
