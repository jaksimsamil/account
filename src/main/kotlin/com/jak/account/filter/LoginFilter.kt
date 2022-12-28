package com.jak.account.filter

import com.jak.account.controller.LoginController
import com.jak.account.util.SessionCode
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
@WebFilter("/*")
class LoginFilter : Filter {

        private val logger = LoggerFactory.getLogger(LoginFilter::class.java)

        override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
                logger.info("[Logging]// start")
                val httpServletRequest = servletRequest as HttpServletRequest
                val httpServletResponse = servletResponse as HttpServletResponse
                //TODO: 필터 로직 구현 하기
//                val session = httpServletRequest.getSession(false)
//                if (session === null || session.getAttribute(SessionCode.LoginUser.getSessionName()) === null) {
                filterChain.doFilter(httpServletRequest, httpServletResponse)
//                        return
//                }
//                httpServletResponse.sendRedirect("/")
                logger.info("[Logging]// end")

        }
}