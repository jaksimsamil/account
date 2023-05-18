package com.jak.account.dto

import java.util.*
import jakarta.persistence.*
import java.text.SimpleDateFormat

@Entity(name="expense")
class Expense (
        @Column(name = "seq") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val seq: Int,
        @Column(name = "fix_value") val fixValue: Int,
        @Column(name = "var_value") val varValue: Int,
        @Column(name = "agg_date") val aggDate: Date
)  {
        fun toResponse() = ExpenseResponse(
                seq = seq,
                fixValue = fixValue,
                varValue = varValue,
                aggDate = SimpleDateFormat("yyyy/MM").format(aggDate)
        )
}