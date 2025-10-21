package com.josedev.expensesapp.data.di

import com.josedev.expensesapp.data.ExpenseRepositoryImpl
import com.josedev.expensesapp.data.PreExpenseRepositoryImpl
import com.josedev.expensesapp.data.local.LocalDataStorage
import com.josedev.expensesapp.data.remote.RemoteDataStorage
import com.josedev.expensesapp.domain.ExpenseRepository
import com.josedev.expensesapp.domain.PreExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideExpenseRepository(
        remoteDataStorage: RemoteDataStorage,
        localDataStorage: LocalDataStorage
    ): ExpenseRepository {
        return ExpenseRepositoryImpl(
            remoteDataStorage,
            localDataStorage
        )
    }

    @Singleton
    @Provides
    fun providePreExpenseRepository(
        remoteDataStorage: RemoteDataStorage,
        localDataStorage: LocalDataStorage
    ): PreExpenseRepository {
        return PreExpenseRepositoryImpl(
            remoteDataStorage,
            localDataStorage
        )
    }
}