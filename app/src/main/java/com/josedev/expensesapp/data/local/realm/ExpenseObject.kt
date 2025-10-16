package com.josedev.expensesapp.data.local.realm

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class ExpenseObject: RealmObject {

    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var value: Double = 0.0
    var type: String = ""
}