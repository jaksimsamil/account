package com.jak.account.service

import com.jak.account.dto.User
import com.jak.account.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class LoginService (private val userRepository: UserRepository) {

        fun loginIdCheck(id: String): User? {
                return userRepository.findById(id)
        }
}