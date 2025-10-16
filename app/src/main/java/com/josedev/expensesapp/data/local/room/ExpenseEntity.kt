package com.josedev.expensesapp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: String,
    val title: String,
    val value: Double,
    val type: String
)
