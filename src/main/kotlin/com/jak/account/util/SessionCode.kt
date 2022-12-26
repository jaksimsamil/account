package com.jak.account.util

import java.io.ObjectInputStream.GetField

enum class SessionCode {
        LoginUser;

        fun getSessionName(): String =
                when (this) {
                        LoginUser -> "loginUser"
                }
}