package com.performnacetest.testmvc.config

import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.performnacetest.testmvc.repository"])
class MongoConfig {
    @Bean
    fun mongoTemplate(): MongoTemplate {
        val mongoClient = MongoClients.create("mongodb://localhost:27017")
        val factory = SimpleMongoClientDatabaseFactory(mongoClient, "test")
        return MongoTemplate(factory)

    }
}
