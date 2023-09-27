package com.jak.account.controller

import com.jak.account.service.LoginService
import com.jak.account.util.SessionCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
class LoginHomeController(
        private val loginService: LoginService
) {
        private val logger = LoggerFactory.getLogger(LoginHomeController::class.java)

        @GetMapping("/")
        fun login(): String {
                return "login"
        }

        @GetMapping("/home")
        fun home(): String {
                return "home"
        }

        @PostMapping("/loginCheck")
        fun loginIdCheck(
                //TODO:  Parameter Validate
                @RequestParam("id") id: String,
                @RequestParam("password") password: String,
                model: Model,
                redirectAttributes: RedirectAttributes,
                httpServletRequest: HttpServletRequest,
                httpServletResponse: HttpServletResponse
        ): String {
                logger.info("[Logging]// id:{}, password:{}", id, password)
                val user = loginService.loginIdCheck( id, password )
                if (user === null) return "redirect:/"

                val sessionCodeName = SessionCode.LoginUser.getSessionName()
                val session = httpServletRequest.getSession(true)
                session.setAttribute(sessionCodeName, user)
                return "redirect:/home"
        }
}