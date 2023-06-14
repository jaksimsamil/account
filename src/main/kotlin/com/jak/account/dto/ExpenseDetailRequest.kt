package com.jak.account.dto

import java.util.*

data class ExpenseDetailRequest (
        val seq: Int?,
        val amount: Int,
        val useCode: String,
        val etc: String?,
        val regYm: String,
        val regDate: Date?,
        val modDate: Date?
) {
        fun toEntity() = ExpenseDetail(
                seq = seq,
                amount = amount,
                useCode = useCode,
                etc = etc,
                regYm = regYm,
                regDate = regDate,
                modDate = modDate
        )
}
