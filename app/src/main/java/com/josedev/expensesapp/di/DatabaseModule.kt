package com.josedev.expensesapp.di

import android.app.Application
import androidx.room.Room
import com.josedev.expensesapp.data.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        application: Application
    ): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, "room_database.db")
                .build()
    }

    @Provides
    fun providesExpenseDao(appDatabase: AppDatabase) = appDatabase.expenseDao()

    @Provides
    fun providesPreExpenseDao(appDatabase: AppDatabase) = appDatabase.preExpenseDao()
}