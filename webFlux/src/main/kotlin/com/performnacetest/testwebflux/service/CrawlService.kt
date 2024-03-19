package com.performnacetest.testwebflux.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CrawlService(
    private val webCrawlerService: WebCrawlerService,
    private val webPageService: WebPageService
) {

    fun crawlAndSave(url: String): Mono<String> {
        return webCrawlerService.crawl(url)
            .flatMap { html ->
                val title = webCrawlerService.parseHtml(html)
                webPageService.saveWebPage(url, title)
            }
            .map { "Data successfully crawled and saved for URL: $url" }
            .onErrorResume { error ->
                Mono.just("Error: ${error.message}")
            }
    }
}
