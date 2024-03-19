package com.performnacetest.testmvc.repository

import com.performnacetest.testmvc.entity.WebPage
import org.springframework.data.mongodb.repository.MongoRepository

interface WebPageRepository : MongoRepository<WebPage, String>