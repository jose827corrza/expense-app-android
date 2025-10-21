package com.josedev.expensesapp.domain

data class PreExpense(
    val id: Long = 0,
    val title: String = "",
    val value: Double = 0.0,
    val type: String = "",
    val isSent: Boolean = false
)
