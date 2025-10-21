package com.josedev.expensesapp.data.remote

import com.josedev.expensesapp.data.ExpenseDto
import com.josedev.expensesapp.domain.Expense

fun ExpenseDto.toDomain(): Expense {
    return Expense(
        id = this.id,
        title = this.title,
        value = this.value,
        type = this.type
    )
}