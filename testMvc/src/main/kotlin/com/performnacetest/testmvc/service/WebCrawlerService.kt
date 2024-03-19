package com.performnacetest.testmvc.service

import org.jsoup.Jsoup
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WebCrawlerService(private val restTemplate: RestTemplate) {

    fun crawl(url: String): String {
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        return response.body ?: ""
    }

    fun parseHtml(html: String): String {
        val doc = Jsoup.parse(html)
        return doc.title()
    }
}
