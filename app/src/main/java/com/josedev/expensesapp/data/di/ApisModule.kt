package com.josedev.expensesapp.data.di

import com.josedev.expensesapp.data.ExpenseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApisModule {

    @Provides
    @Singleton
    fun provideApi(
        retrofit: Retrofit
    ): ExpenseApi = retrofit.create(ExpenseApi::class.java)
}