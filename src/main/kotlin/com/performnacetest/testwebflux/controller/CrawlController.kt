package com.performnacetest.testwebflux.controller

import com.performnacetest.testwebflux.entity.WebPage
import com.performnacetest.testwebflux.service.CrawlService
import com.performnacetest.testwebflux.service.WebPageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

data class CrawlRequest(val url: String)

@RestController
class CrawlController(
    private val crawlerService: CrawlService,
    private val webPageService: WebPageService
) {

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

    @GetMapping("/webpages/first")
    fun getFirstWebPage(): Mono<WebPage> {
        return webPageService.getFirstWebPage()
    }
}

