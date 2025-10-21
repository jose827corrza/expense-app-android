package com.josedev.expensesapp.domain

data class Expense(
    val id: String,
    val title: String,
    val value: Double,
    val type: String
)
