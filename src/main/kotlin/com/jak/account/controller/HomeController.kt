package com.jak.account.controller

import com.jak.account.service.LoginService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

        @GetMapping("/")
        fun home(): String {
                return "home"
        }
}