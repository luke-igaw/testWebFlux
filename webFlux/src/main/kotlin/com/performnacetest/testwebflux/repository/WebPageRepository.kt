package com.performnacetest.testwebflux.repository

import com.performnacetest.testwebflux.entity.WebPage
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface WebPageRepository : ReactiveMongoRepository<WebPage, String> {
    override fun findAll(): Flux<WebPage>
}