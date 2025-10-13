package com.josedev.expensesapp.data

import com.squareup.moshi.JsonClass

@JsonClass( generateAdapter = true )
data class ExpenseDto(
    val id: String,
    val title: String,
    val value: Double,
    val type: String
)
