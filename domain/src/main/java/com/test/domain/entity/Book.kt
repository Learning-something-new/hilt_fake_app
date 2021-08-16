package com.test.domain.entity

data class Book(
    val authors: List<String>,
    val title: String,
    val subtitle: String,
    val coverUrl: String
)
