package com.josedev.expensesapp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pre_expenses")
data class PreExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: String,
    val title: String,
    val value: Double,
    val type: String,
    val isSent: Boolean
)
