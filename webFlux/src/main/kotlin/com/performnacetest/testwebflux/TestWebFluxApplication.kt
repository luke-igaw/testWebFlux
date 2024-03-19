package com.performnacetest.testwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class TestWebFluxApplication

fun main(args: Array<String>) {
    runApplication<TestWebFluxApplication>(*args)
}
