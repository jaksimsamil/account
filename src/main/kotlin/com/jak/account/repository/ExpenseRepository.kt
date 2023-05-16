package com.jak.account.repository

import com.jak.account.dto.Expense
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository: JpaRepository<Expense, Int> {
        fun findAllBy(by: Sort): List<Expense>
}