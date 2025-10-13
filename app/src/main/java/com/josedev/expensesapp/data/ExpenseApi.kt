package com.josedev.expensesapp.data

import androidx.annotation.Px
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ExpenseApi {

    @GET("expenses")
    suspend fun getExpenses(): Response<List<ExpenseDto>>

    @POST("expenses")
    suspend fun saveExpense(): Response<Unit>
}