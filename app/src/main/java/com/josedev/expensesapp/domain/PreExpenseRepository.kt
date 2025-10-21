package com.josedev.expensesapp.domain

import kotlinx.coroutines.flow.Flow

interface PreExpenseRepository {

    suspend fun savePreExpense(reExpense: PreExpense): Result<Unit>

    fun getPreExpenses(): Flow<Result<List<PreExpense>>>

    suspend fun deletePreExpense(id: Long)

    suspend fun retrySync(id: Long)
}