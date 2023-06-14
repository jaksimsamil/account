package com.jak.account.repository

import com.jak.account.dto.ExpenseDetail
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseDetailRepository: JpaRepository<ExpenseDetail, Int> {
        /*fun findAllBy(by: Sort): List<ExpenseDetail>*/
        fun findAllBy(): List<ExpenseDetail>
        fun findAllByRegYm(regYm: String): List<ExpenseDetail>
        fun save(expenseDetail: ExpenseDetail): ExpenseDetail
}