package com.josedev.expensesapp.data

import com.josedev.expensesapp.data.local.room.ExpenseEntity
import com.josedev.expensesapp.data.local.room.PreExpenseEntity
import com.josedev.expensesapp.domain.Expense
import com.josedev.expensesapp.domain.PreExpense

fun ExpenseEntity.toDomain(): Expense {
    return Expense(
        id = this.id,
        title = this.title,
        value = this.value,
        type = this.type
    )
}

fun Expense.toEntity(): ExpenseEntity {
    return ExpenseEntity(
        id = this.id,
        title = this.title,
        value = this.value,
        type = this.type
    )
}

fun PreExpenseEntity.toDomain(): PreExpense {
    return PreExpense(
        id = this.id,
        title = this.title,
        value = this.value,
        type = this.type,
        isSent = this.isSent
    )
}