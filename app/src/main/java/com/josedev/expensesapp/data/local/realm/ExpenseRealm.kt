package com.josedev.expensesapp.data.local.realm

import io.realm.kotlin.Realm
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExpenseRealm @Inject constructor(
    private val realms: Realm
) {

    suspend fun insertExpenses(expensesObject: List<ExpenseObject>){
        realms.write {
            expensesObject.forEach { orderObject ->
                copyToRealm(orderObject)
            }
        }
    }

    fun getExpenses(): Flow<List<ExpenseObject>> {
        return realms.asFlow().map { realmChange ->
            realmChange.realm.query(ExpenseObject::class).find()
        }
    }

    suspend fun getExpenseById(id: String): ExpenseObject? {
        return realms.query(ExpenseObject::class, "id == $0").first().find()
    }
}