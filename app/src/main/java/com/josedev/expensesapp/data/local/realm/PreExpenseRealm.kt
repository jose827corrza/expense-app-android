package com.josedev.expensesapp.data.local.realm

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreExpenseRealm @Inject constructor(
    private val realms: Realm
) {
    suspend fun insertPreExpense(preExpenseObject: PreExpenseObject) {
        realms.write {
            copyToRealm(preExpenseObject)
        }
    }

    fun getPreExpenses(): Flow<List<PreExpenseObject>> {
        return realms.query(PreExpenseObject::class).asFlow().map {
            it.list
        }
    }

    suspend fun deleteById(preOrderId: Long) {
        realms.write {
            query<PreExpenseObject>("id == $0", preOrderId).first().find()?.let { delete(it) }
        }
    }

    suspend fun updateIsSent(preOrderId: Long, isSent: Boolean) {
        realms.write {
            query<PreExpenseObject>("id == $0", preOrderId).first().find()?.let { order ->
                order.isSent = isSent
            }
        }
    }
}