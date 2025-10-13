package com.josedev.expensesapp.data

import jakarta.inject.Inject

class RemoteDataStorage @Inject constructor(
    val expenseApi: ExpenseApi
)
{
    suspend fun getExpenses() = runCatching {
        val response = expenseApi.getExpenses()

        if (response.isSuccessful){
            response.body().orEmpty()
        } else {
            throw Exception("${response.code()}: ${response.message()}")
        }
    }

    suspend fun saveExpense() = runCatching {
        val response = expenseApi.saveExpense()

        if (response.isSuccessful){
            response.body() ?: Unit
        } else {
            throw Exception("${response.code()}: ${response.message()}")
        }
    }
}