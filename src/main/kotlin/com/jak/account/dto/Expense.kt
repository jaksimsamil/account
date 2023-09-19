package com.jak.account.dto

import java.util.*
import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import java.text.SimpleDateFormat

@DynamicInsert
@Entity(name="expense")
class Expense (
        @Column(name = "seq") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val seq: Int?,
        @Column(name = "fix") val fix: Int,
        @Column(name = "fluct") val fluct: Int,
        @Column(name = "etc") val etc: Int,
        @Column(name = "agg_date") val aggDate: Date?
)  {
        fun toResponse() = ExpenseResponse(
                seq = seq,
                fix = fix,
                fluct = fluct,
                etc = etc,
                aggDate = aggDate
        )
}