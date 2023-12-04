package com.example.andersenretrofit.data

import com.example.andersenretrofit.domain.GetCurrencyByNameUseCase
import com.example.andersenretrofit.domain.GetCurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CurrencyModul {

    @Singleton
    @Provides
    fun getApiClient() = ApiClient()

    @Singleton
    @Provides
    fun getRepository(apiClient: ApiClient): GetCurrencyRepository = GetCurrencyRepositoryImpl(apiClient)

    @Singleton
    @Provides
    fun getCurrencyByNameUseCase(getCurrency:GetCurrencyRepository) :GetCurrencyByNameUseCase = GetCurrencyByNameUseCase(getCurrency)
}
