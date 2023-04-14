package com.jak.account.controller

import com.jak.account.service.ExpenseService
import com.jak.account.util.SessionCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
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
                val session = httpServletRequest.getSession(false)
                if (session === null )  return "redirect:/"

                val sessionCodeName = SessionCode.LoginUser.getSessionName()
                model.addAttribute(sessionCodeName, session.getAttribute(sessionCodeName))
                model.addAttribute("expenseList", expenseService.getExpenseList())
                return "account"
        }
}