package com.jak.account.controller

import com.jak.account.dto.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Controller
class AssetController(

) {
        private val logger = LoggerFactory.getLogger(AssetController::class.java)

        @GetMapping("/asset")
        fun asset(): String {
                return "asset"
        }
}