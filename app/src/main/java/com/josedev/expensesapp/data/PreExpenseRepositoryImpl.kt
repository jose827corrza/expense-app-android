package com.josedev.expensesapp.data

import com.josedev.expensesapp.data.local.LocalDataStorage
import com.josedev.expensesapp.data.local.room.PreExpenseEntity
import com.josedev.expensesapp.data.remote.RemoteDataStorage
import com.josedev.expensesapp.domain.PreExpense
import com.josedev.expensesapp.domain.PreExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreExpenseRepositoryImpl(
    private val remoteDataStorage: RemoteDataStorage,
    private val localDataStorage: LocalDataStorage
): PreExpenseRepository {
    override suspend fun savePreExpense(preExpense: PreExpense) =
        remoteDataStorage.savePreExpense().also { result ->
            localDataStorage.savePreExpenseRoom(
                PreExpenseEntity(
                    id = preExpense.id,
                    title = preExpense.title,
                    value = preExpense.value,
                    type = preExpense.type,
                    isSent = result.isSuccess
                )
            )
        }

    override fun getPreExpenses(): Flow<Result<List<PreExpense>>> {
        return localDataStorage.preExpensesRoom().map { preExpense ->
            runCatching {
                preExpense.map { it.toDomain() }
            }
        }
    }

    override suspend fun deletePreExpense(id: Long) = localDataStorage.deleteByPreExpenseId(id)


    override suspend fun retrySync(id: Long) {
       val result = remoteDataStorage.savePreExpense()

        if (result.isSuccess) {
            localDataStorage.retrySyncRoom(id, true)
        }
    }
}