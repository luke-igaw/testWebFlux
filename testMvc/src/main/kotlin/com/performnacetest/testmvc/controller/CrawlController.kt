package com.performnacetest.testmvc.controller

import com.performnacetest.testmvc.entity.WebPage
import com.performnacetest.testmvc.service.CrawlService
import com.performnacetest.testmvc.service.WebPageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class CrawlRequest(val url: String)

@RestController
class CrawlController(
    private val crawlerService: CrawlService,
    private val webPageService: WebPageService
) {

    @PostMapping("/crawl")
    fun crawlAndSave(@RequestBody request: CrawlRequest): ResponseEntity<String> {
        val result = crawlerService.crawlAndSave(request.url)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/webpages/first")
    fun getFirstWebPage(): WebPage? {
        return webPageService.getFirstWebPage()
    }
}
