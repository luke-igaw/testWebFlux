package com.performnacetest.testwebflux.controller

import com.performnacetest.testwebflux.service.CrawlService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono

data class CrawlRequest(val url: String)

@Controller
class CrawlController(private val crawlerService: CrawlService) {

    @PostMapping("/crawl")
    fun crawlAndSave(@RequestBody request: CrawlRequest): Mono<ResponseEntity<String>> {
        return crawlerService.crawlAndSave(request.url)
            .map { content ->
                ResponseEntity.ok(content)
            }
            .onErrorResume { error ->
                Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: ${error.message}"))
            }
    }
}

