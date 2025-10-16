package com.josedev.expensesapp.di

import com.josedev.expensesapp.data.local.realm.ExpenseObject
import com.josedev.expensesapp.data.local.realm.PreExpenseObject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RealmModule {

    @Provides
    @Singleton
    fun provideRealmConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder(
            schema = setOf(PreExpenseObject::class, ExpenseObject::class)
        )
            .name("realm_database.db")
            .schemaVersion(1)
            .build()
    }
    @Provides
    @Singleton
    fun provideRealm(realmConfiguration: RealmConfiguration): Realm {
        return Realm.open(realmConfiguration)
    }
}