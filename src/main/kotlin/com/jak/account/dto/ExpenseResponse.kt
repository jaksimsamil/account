package com.jak.account.dto

//EL1008E
// @참고: https://medium.com/@filipefox/introduction-8a1145c08d00
data class ExpenseResponse (
        val seq: Int,
        val fixAmt: Int,
        val varAmt: Int,
        val aggDate: String
)