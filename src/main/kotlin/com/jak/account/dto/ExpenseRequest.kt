package com.jak.account.dto

import java.util.*

data class ExpenseRequest (
        val seq: Int?,
        val fix: Int,
        val fluct: Int,
        val etc: Int,
        val regYm: String,
        val regDate: Date?,
        val modDate: Date?
) {
        fun toEntity() = Expense (
                seq = seq,
                fix = fix,
                fluct = fluct,
                etc = etc,
                regYm = regYm,
                regDate = regDate,
                modDate = modDate
        )
}