package com.performnacetest.testwebflux.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class WebCrawlerService(private val webClientBuilder: WebClient.Builder) {

    private val webClient: WebClient = webClientBuilder.build()

    fun crawl(url: String): Mono<String> {
        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun parseHtml(html: String): String {
        val doc = Jsoup.parse(html)
        return doc.title()
    }
}


