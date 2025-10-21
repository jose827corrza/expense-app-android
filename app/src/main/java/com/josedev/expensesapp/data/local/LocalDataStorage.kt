package com.josedev.expensesapp.data.local

import com.josedev.expensesapp.data.local.realm.ExpenseObject
import com.josedev.expensesapp.data.local.realm.ExpenseRealm
import com.josedev.expensesapp.data.local.realm.PreExpenseObject
import com.josedev.expensesapp.data.local.realm.PreExpenseRealm
import com.josedev.expensesapp.data.local.room.ExpenseDao
import com.josedev.expensesapp.data.local.room.ExpenseEntity
import com.josedev.expensesapp.data.local.room.PreExpenseDao
import com.josedev.expensesapp.data.local.room.PreExpenseEntity
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class LocalDataStorage @Inject constructor(
    private val expenseDao: ExpenseDao,
    private val preExpenseDao: PreExpenseDao,
    private val expenseRealm: ExpenseRealm,
    private val preExpenseRealm: PreExpenseRealm
) {

    // Expenses ROOM

    suspend fun upsertExpenseRoom(expenses: List<ExpenseEntity>) = expenseDao.insertExpense(expenses)

    fun getExpensesRoom() = expenseDao.getExpenses()

    suspend fun getExpenseByIdRoom(id: String): Result<ExpenseEntity?> = runCatching { expenseDao.getExpense(id) }

    // Expenses Realm

    suspend fun insertExpensesRealm(expenses: List<ExpenseObject>) = expenseRealm.insertExpenses(expenses)

    fun getExpensesRealm() = expenseRealm.getExpenses()

    suspend fun getExpenseByIdRealm(id: String): Result<ExpenseObject?> = runCatching {
        expenseRealm.getExpenseById(id)
    }

    // PreExpenses ROOM

    suspend fun savePreExpenseRoom(preExpense: PreExpenseEntity) = preExpenseDao.insertPreExpense(preExpense)

    fun preExpensesRoom(): Flow<List<PreExpenseEntity>> = preExpenseDao.getPreExpenses()

    suspend fun deleteByPreExpenseId(id: Long) = preExpenseDao.deletePreExpense(id)

    suspend fun retrySyncRoom(id: Long, isSent: Boolean) = preExpenseDao.updateIsSent(id, isSent)

    // PreExpenses Realm

    suspend fun savePreExpenseRealm(preExpense: PreExpenseObject) = preExpenseRealm.insertPreExpense(preExpense)

    fun getAllPreExpensesRealm(): Flow<List<PreExpenseObject>> = preExpenseRealm.getPreExpenses()

    suspend fun deleteByIdRealm(id: Long) = preExpenseRealm.deleteById(id)

    suspend fun retrySyncRealm(id: Long, isSent: Boolean) = preExpenseRealm.updateIsSent(id, isSent)
}



