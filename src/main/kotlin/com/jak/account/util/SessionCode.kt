package com.jak.account.util

enum class SessionCode {
        LoginUser;

        fun getSessionName(): String =
                when (this) {
                        LoginUser -> "loginUser"
                }
}