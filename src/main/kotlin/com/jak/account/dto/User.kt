package com.jak.account.dto

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID

@Entity(name="users")
data class User(
        @Column(name = "uuid")  @Id @GeneratedValue val uuid: String?,
        @Column(name = "id")  val id: String?,
        @Column(name = "password")  val password: String?,
        @Column(name = "auth_level")  val authLevel: String? = null
) {
        constructor() : this(null, null, null, null)
}