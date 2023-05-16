package com.jak.account.service

import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import com.jak.account.dto.ExpenseResponse
import com.jak.account.repository.ExpenseRepository

@Service
class ExpenseService (
        private val expenseRepository: ExpenseRepository
        ) {
        private val logger = LoggerFactory.getLogger(ExpenseService::class.java)

        fun getExpenseList() : List<ExpenseResponse> {
                val expenses = expenseRepository.findAllBy(Sort.by(Sort.Direction.ASC, "aggDate"))
                return expenses.map { it.toResponse() }
        }
}