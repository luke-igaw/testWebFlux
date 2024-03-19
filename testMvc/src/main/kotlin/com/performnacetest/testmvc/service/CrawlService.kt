package com.performnacetest.testmvc.service

import org.springframework.stereotype.Service

@Service
class CrawlService(
    private val webCrawlerService: WebCrawlerService,
    private val webPageService: WebPageService
) {

    fun crawlAndSave(url: String): String {
        val html = webCrawlerService.crawl(url)
        val title = webCrawlerService.parseHtml(html)
        return try {
            webPageService.saveWebPage(url, title)
            "Data successfully crawled and saved for URL: $url"
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}
