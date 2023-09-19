package com.jak.account.controller

import com.jak.account.dto.*
import com.jak.account.service.ExpenseService
import com.jak.account.util.SessionCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
class AccountController(
        private val expenseService: ExpenseService
) {
        private val logger = LoggerFactory.getLogger(AccountController::class.java)

        @GetMapping("/account")
        fun account( model: Model,
                  httpServletRequest: HttpServletRequest,
                  httpServletResponse: HttpServletResponse
        ): String {
                logger.info("AccountController Start")
                // pre-condition: Logon success on LoginFilter
                val session = httpServletRequest.getSession(false)
                val sessionCodeName = SessionCode.LoginUser.getSessionName()
                model.addAttribute(sessionCodeName, session.getAttribute(sessionCodeName))
                model.addAttribute("expenseList", expenseService.getExpenseList())
                return "account"
        }

        @GetMapping("/detail/{regYm}")
        @ResponseBody
        fun getDetailInfo(
                @PathVariable regYm: String
        ): List<ExpenseDetailResponse> {
                // pre-condition: Logon success on LoginFilter
                return  expenseService.getExpenseDetailList(regYm)
        }

        @PostMapping("/save")
        @ResponseBody
        fun saveData(
                @RequestBody expenseRequest: ExpenseRequest
        ): ExpenseResponse {
                // pre-condition: Logon success on LoginFilter
                val expense = expenseService.setExpense(expenseRequest.toEntity())
                return expense.toResponse()
        }
}