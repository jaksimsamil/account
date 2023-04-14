package com.jak.account.dto

import jakarta.persistence.*
import java.util.*

@Entity(name="expense")
data class Expense(
        @Column(name = "seq")  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val seq: Int? = 1,
        @Column(name = "fix_value")  val fixValue: Int? = 0,
        @Column(name = "var_value")  val varValue: Int? = 0,
        @Column(name = "agg_date")  val aggDate: Date? = Date(System.currentTimeMillis())
) {
        constructor() : this(null, null, null,  null)
}