package com.jak.account.service

import com.jak.account.dto.Expense
import com.jak.account.dto.ExpenseDetail
import com.jak.account.dto.ExpenseDetailResponse
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import com.jak.account.dto.ExpenseResponse
import com.jak.account.repository.ExpenseDetailRepository
import com.jak.account.repository.ExpenseRepository

@Service
class ExpenseService (
        private val expenseRepository: ExpenseRepository,
        private val expenseDetailRepository: ExpenseDetailRepository
        ) {
        private val logger = LoggerFactory.getLogger(ExpenseService::class.java)

        fun getExpenseList() : List<ExpenseResponse> {
                val expenses = expenseRepository.findAllBy(Sort.by(Sort.Direction.ASC, "aggDate"))
                return expenses.map { it.toResponse() }
        }

        fun getExpenseDetailList() : List<ExpenseDetailResponse> {
                val expenseDetails = expenseDetailRepository.findAllBy()
                return expenseDetails.map { it.toResponse() }
        }

        fun getExpenseDetailList(regYm: String) : List<ExpenseDetailResponse> {
                val expenseDetails = expenseDetailRepository.findAllByRegYm(regYm)
                return expenseDetails.map { it.toResponse() }
        }

        fun setExpense(expense: Expense): Expense {
                return expenseRepository.save(expense)
        }
}