package com.jak.account.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class DefinedExceptionHandler {
        @ExceptionHandler(DefinedException::class)
        protected fun handleDefinedException(e: DefinedException): ResponseEntity<String> {
                return ResponseEntity
                                .status(e.definedExceptionCode.status)
                                .body(e.definedExceptionCode.message)
        }
}