package com.test.data.books.remote

import com.test.data.mapper.BooksToPresentationMapper
import com.test.domain.entity.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksApiServiceImpl {

    companion object {
        private const val BASE_URL = "http://openlibrary.org/"
    }

    private val booksApi: BooksApi by lazy { createBooksApi() }

    private fun createBooksApi(): BooksApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BooksApi::class.java)

    suspend fun searchBooks(query: String): List<Book> {
        return booksApi.getBooks(query).docBooks.map(BooksToPresentationMapper::convert)
    }
}