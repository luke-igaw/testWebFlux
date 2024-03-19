package com.performnacetest.testwebflux.repository

import com.performnacetest.testwebflux.entity.WebPage
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface WebPageRepository : ReactiveMongoRepository<WebPage, String>