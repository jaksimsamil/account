package com.jak.account.repository

import com.jak.account.dto.Expense
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository: CrudRepository<Expense, Int> {
        fun findAllBy(): List<Expense>
}