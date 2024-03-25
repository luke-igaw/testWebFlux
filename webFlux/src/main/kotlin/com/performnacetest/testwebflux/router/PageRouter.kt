package com.performnacetest.testwebflux.router

import com.performnacetest.testwebflux.handler.PageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class PageRouter {
    @Bean
    fun main(pageHandler: PageHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/main")
            .and(RequestPredicates.accept(MediaType.TEXT_HTML)),
            HandlerFunction { serverRequest -> pageHandler.main(serverRequest) })
    }
}
