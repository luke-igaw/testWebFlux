package com.performnacetest.testwebflux.service

import com.performnacetest.testwebflux.entity.WebPage
import com.performnacetest.testwebflux.repository.WebPageRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class WebPageService(private val webPageRepository: WebPageRepository) {

    fun saveWebPage(url: String, title: String): Mono<*> {
        val webPage = WebPage(null, url, title)
        return webPageRepository.save(webPage).then()
    }
}
