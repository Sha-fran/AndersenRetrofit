package com.example.andersenretrofit.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CurrencyModul {

    @Provides
    fun getApiClient() = ApiClient()

    @Provides
    fun getRepository(apiClient: ApiClient) = GetCurrencyRepositoryImpl(apiClient)


}
