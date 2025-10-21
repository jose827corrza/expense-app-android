package com.josedev.expensesapp.data

import com.josedev.expensesapp.data.local.LocalDataStorage
import com.josedev.expensesapp.data.remote.RemoteDataStorage
import com.josedev.expensesapp.data.remote.toDomain
import com.josedev.expensesapp.domain.Expense
import com.josedev.expensesapp.domain.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import okhttp3.internal.ignoreIoExceptions

class ExpenseRepositoryImpl(
    private val remoteDataStorage: RemoteDataStorage,
    private val localDataStorage: LocalDataStorage
): ExpenseRepository {
    override fun getExpenses(): Flow<Result<List<Expense>>> {
        return localDataStorage.getExpensesRoom()
            .map { localExpenses ->
                Result.success(localExpenses.map { it.toDomain() })
            }.onStart {
                val remoteResult = remoteDataStorage.getExpenses().mapCatching { list ->
                    list.map { it.toDomain() }
                }

                remoteResult.getOrNull()?.let { remoteExpenses ->
                    localDataStorage.upsertExpenseRoom(remoteExpenses.map { it.toEntity() })
                }
            }.catch { exception ->
                emit(Result.failure(exception))
            }
    }

    override suspend fun getExpense(id: String): Result<Expense?> = localDataStorage.getExpenseByIdRoom(id).mapCatching {
        it?.toDomain()
    }
}