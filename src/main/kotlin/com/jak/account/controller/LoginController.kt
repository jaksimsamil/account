package com.jak.account.controller

import com.jak.account.dto.User
import com.jak.account.service.LoginService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@Controller
class LoginController(
        private val loginService: LoginService
) {

        @GetMapping("/")
        fun loginIdCheck(model: Model, @RequestBody id: String): String {
                model.addAttribute("userInfo", loginService.loginIdCheck( id ))
                return "login"
        }
}