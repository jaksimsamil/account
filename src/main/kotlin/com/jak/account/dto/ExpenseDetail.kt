package com.jak.account.dto

import java.util.*
import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert

// Apply to table default value when JPA insert
@DynamicInsert
@Entity(name="expense_detail")
class ExpenseDetail (
        @Column(name = "seq") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val seq: Int?,
        @Column(name = "amount") val amount: Int,
        @Column(name = "use_code") val useCode: String,
        @Column(name = "etc") val etc: String?,
        @Column(name = "reg_ym") val regYm: String,
        @Column(name = "reg_date") val regDate: Date?,
        @Column(name = "mod_date") val modDate: Date?
)  {
        fun toResponse() = ExpenseDetailResponse(
                seq = seq,
                amount = amount,
                useCode = useCode,
                etc = etc,
                regYm = regYm,
                regDate = regDate,
                modDate = modDate
        )
}