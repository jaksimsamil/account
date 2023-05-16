package com.jak.account.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.PatternMatchUtils

@Component
@WebFilter("/*")
class LoginFilter : Filter {
        private val logger = LoggerFactory.getLogger(LoginFilter::class.java)
        private val whiteUriList = arrayOf("/")

        override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
                val httpServletRequest = servletRequest as HttpServletRequest
                val httpServletResponse = servletResponse as HttpServletResponse

                //TODO: 필터 로직 구현 하기
                /*
                1. 로그인을 한 경우,
                1. 로그인페이지("/")로 접근할 때,
                        1. 로그인을 안했다면, pass
                        2. 로그인을 했다면, "/main"페이지로
                2. 다른페이지("others")로 접근할 때,
                        1. 로그인을 안했다면, 첫페이지("/")로
                        2. 로그인을 했다면, pass
                 */
                //val session = httpServletRequest.getSession(false)
                filterChain.doFilter(httpServletRequest, httpServletResponse)
        }
        private fun isLoginPath(pathUri: String) = PatternMatchUtils.simpleMatch(whiteUriList, pathUri)
}