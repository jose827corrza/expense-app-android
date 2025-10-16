package com.josedev.expensesapp.data.local.realm

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class PreExpenseObject: RealmObject {

    @PrimaryKey
    var id: Long = System.currentTimeMillis()
    var title: String = ""
    var value: Double = 0.0
    var type: String =""
    var isSent: Boolean = false
}