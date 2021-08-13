package com.test.data.books.remote

import com.test.data.entity.BooksSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET("search.json")
    suspend fun getBooks(@Query("q") query: String): BooksSearchResponse
}