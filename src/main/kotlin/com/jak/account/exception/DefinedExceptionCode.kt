package com.jak.account.exception

import org.springframework.http.HttpStatus

enum class DefinedExceptionCode (status: HttpStatus, message: String) {
                BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
                DUPLICATE_REG_MONTH(HttpStatus.BAD_REQUEST, "이미 입력된 월이 있습니다. 월을 확인해주세요.");

                val status: HttpStatus = status
                val message: String = message
}