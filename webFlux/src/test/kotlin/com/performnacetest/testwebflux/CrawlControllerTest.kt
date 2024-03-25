package com.performnacetest.testwebflux

import com.performnacetest.testwebflux.controller.CrawlController
import com.performnacetest.testwebflux.controller.CrawlRequest
import com.performnacetest.testwebflux.service.CrawlService
import com.performnacetest.testwebflux.service.WebPageService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(MockitoExtension::class)
class CrawlControllerTest {

    @Mock
    lateinit var crawlService: CrawlService

    @Mock
    lateinit var webPageService: WebPageService

    @InjectMocks
    lateinit var crawlController: CrawlController

    @Test
    fun `crawlAndSave - success`() {
        val request = CrawlRequest("http://example.com")
        val expectedContent = "Crawled content"
        val expectedResponseEntity = ResponseEntity.ok(expectedContent)

        `when`(crawlService.crawlAndSave(request.url)).thenReturn(Mono.just(expectedContent))

        val result = crawlController.crawlAndSave(request)

        StepVerifier.create(result)
            .expectNext(expectedResponseEntity)
            .verifyComplete()
    }

    @Test
    fun `crawlAndSave - error`() {
        val request = CrawlRequest("http://example.com")
        val errorMessage = "Crawl failed"
        val expectedResponseEntity =
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: $errorMessage")

        `when`(crawlService.crawlAndSave(request.url)).thenReturn(Mono.error(RuntimeException(errorMessage)))

        val result = crawlController.crawlAndSave(request)

        StepVerifier.create(result)
            .expectNext(expectedResponseEntity)
            .verifyComplete()
    }
}
