package com.jak.account.dto

import java.util.*

data class ExpenseDetailResponse (
        val seq: Int?,
        val amount: Int,
        val useCode: String,
        val etc: String?,
        val regYm: String,
        val regDate: Date?,
        val modDate: Date?
)