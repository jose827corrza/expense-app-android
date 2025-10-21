package com.josedev.expensesapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PreExpenseDao {

    @Insert
    suspend fun insertPreExpense(preExpenseEntity: PreExpenseEntity)

    @Query("SELECT * FROM pre_expenses")
    fun getPreExpenses(): Flow<List<PreExpenseEntity>>

    @Query("DELETE FROM pre_expenses WHERE id = :id")
    suspend fun deletePreExpense(id: Long)

    @Query("UPDATE pre_orders SET isSent = :isSent WHERE id = :preOrderId")
    suspend fun updateIsSent(preOrderId: Long, isSent: Boolean)
}