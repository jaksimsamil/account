package com.jak.account.dto

import java.util.*

//EL1008E
// @참고: https://medium.com/@filipefox/introduction-8a1145c08d00
data class ExpenseResponse (
        val seq: Int?,
        val fix: Int,
        val fluct: Int,
        val etc: Int,
        val regYm: String,
        val regDate: Date?,
        val modDate: Date?
)