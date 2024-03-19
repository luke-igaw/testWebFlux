package com.performnacetest.testwebflux.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
@Document(collection = "web_pages")
data class WebPage(
    @Id
    val id: String?,
    val url: String,
    val title: String,
)
