package com.josedev.expensesapp.data.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Upsert
    suspend fun insertExpense(expensesEntity: List<ExpenseEntity>)

    @Query("SELECT * FROM expenses")
    suspend fun getExpenses(): Flow<List<ExpenseEntity>>

    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpense(id: String): ExpenseEntity
}