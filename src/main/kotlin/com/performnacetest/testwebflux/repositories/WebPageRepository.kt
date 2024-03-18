package com.performnacetest.testwebflux.repositories

import com.performnacetest.testwebflux.entity.WebPage
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface WebPageRepository : ReactiveMongoRepository<WebPage, String>