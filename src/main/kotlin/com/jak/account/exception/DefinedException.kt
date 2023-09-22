package com.jak.account.exception

class DefinedException(definedExceptionCode: DefinedExceptionCode): RuntimeException() {
                val definedExceptionCode: DefinedExceptionCode = definedExceptionCode
}