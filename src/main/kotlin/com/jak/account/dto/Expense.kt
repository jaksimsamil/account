package com.jak.account.dto

import java.util.*
import jakarta.persistence.*
import java.text.SimpleDateFormat

@Entity(name="expense")
class Expense (
        @Column(name = "seq") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val seq: Int,
        @Column(name = "fix_amt") val fixAmt: Int,
        @Column(name = "var_amt") val varAmt: Int,
        @Column(name = "agg_date") val aggDate: Date
)  {
        fun toResponse() = ExpenseResponse(
                seq = seq,
                fixAmt = fixAmt,
                varAmt = varAmt,
                aggDate = SimpleDateFormat("yyyy.MM.").format(aggDate)
        )
}