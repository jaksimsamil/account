package com.jak.account.repository

import com.jak.account.dto.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
        fun findById(id: String): User
}