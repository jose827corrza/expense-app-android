package com.josedev.expensesapp.domain

import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    fun getExpenses(): Flow<Result<List<Expense>>>

    suspend fun getExpense(id: String): Result<Expense?>
}