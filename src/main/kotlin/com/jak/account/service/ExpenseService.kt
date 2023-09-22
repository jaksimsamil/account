package com.jak.account.service

import com.jak.account.dto.Expense
import com.jak.account.dto.ExpenseDetail
import com.jak.account.dto.ExpenseDetailResponse
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import com.jak.account.dto.ExpenseResponse
import com.jak.account.exception.DefinedException
import com.jak.account.exception.DefinedExceptionCode
import com.jak.account.repository.ExpenseDetailRepository
import com.jak.account.repository.ExpenseRepository

@Service
class ExpenseService (
        private val expenseRepository: ExpenseRepository,
        private val expenseDetailRepository: ExpenseDetailRepository
        ) {
        private val logger = LoggerFactory.getLogger(ExpenseService::class.java)

        fun getExpenseList() : List<ExpenseResponse> {
                val expenses = expenseRepository.findAllBy(Sort.by(Sort.Direction.ASC, "regDate"))
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
                /*
                        1. 등록 월 조회
                        2. 이미 등록 되어 있는  경우, "등록되어있습니다." 안내하기
                        3. 등록되지 않은 경우, "저장진행"
                */
                if (expenseRepository.findAllByRegYm(expense.regYm).size > 0){
                        throw DefinedException(DefinedExceptionCode.DUPLICATE_REG_MONTH)
                }
                return expenseRepository.save(expense)
        }
}