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
        @Column(name = "reg_ym") val regYm: String,
        @Column(name = "reg_date") val regDate: Date?,
        @Column(name = "mod_date") val modDate: Date?
)  {
        fun toResponse() = ExpenseResponse(
                seq = seq,
                fix = fix,
                fluct = fluct,
                etc = etc,
                regYm = regYm,
                regDate = regDate,
                modDate = modDate
        )
}