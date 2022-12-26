package com.jak.account.service

import com.jak.account.controller.LoginController
import com.jak.account.dto.User
import com.jak.account.repository.UserRepository
import com.jak.account.util.AuthLevel
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class LoginService (private val userRepository: UserRepository) {

        private val logger = LoggerFactory.getLogger(LoginController::class.java)
        fun loginIdCheck(id: String, password: String): User? {
                val user = userRepository.findById(id)
                logger.info(user.toString())
                return if (
                        user === null
                        || !password.equals(user.password)
                )  null else user
        }
}