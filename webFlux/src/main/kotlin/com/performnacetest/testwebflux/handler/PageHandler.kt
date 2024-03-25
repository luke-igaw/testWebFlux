package com.performnacetest.testwebflux.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PageHandler {
    fun main(request: ServerRequest): Mono<ServerResponse> {
        // ServerRequest에서 모델을 추출하거나 필요한 데이터를 가져와서 처리합니다.
        val model = mutableMapOf<String, Any>()
        // 예: URI에서 필요한 정보를 추출하여 모델에 추가
        val uriVariables = request.pathVariables()
        model["uriVariables"] = uriVariables
        // 필요한 경우 다른 데이터도 모델에 추가할 수 있습니다.

        // ServerResponse를 생성하여 모델과 함께 반환합니다.
        return ServerResponse.ok().render("main", model)
    }
}
