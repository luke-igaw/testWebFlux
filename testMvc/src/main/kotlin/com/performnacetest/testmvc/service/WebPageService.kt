package com.performnacetest.testmvc.service

import com.performnacetest.testmvc.entity.WebPage
import com.performnacetest.testmvc.repository.WebPageRepository
import org.springframework.stereotype.Service

@Service
class WebPageService(private val webPageRepository: WebPageRepository) {

    fun saveWebPage(url: String, title: String) {
        val webPage = WebPage(null, url, title)
        webPageRepository.save(webPage)
    }

    fun getFirstWebPage(): WebPage? {
        return webPageRepository.findAll().firstOrNull()
    }
}
