package com.josedev.expensesapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = [ExpenseEntity::class, PreExpenseEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao
    abstract fun preExpenseDao(): PreExpenseDao
}