package com.jak.account.service

import com.jak.account.repository.ExpenseRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExpenseService (
        private val expenseRepository: ExpenseRepository

        ) {
        private val logger = LoggerFactory.getLogger(ExpenseService::class.java)

        fun getExpenseList() = expenseRepository.findAllBy()
}