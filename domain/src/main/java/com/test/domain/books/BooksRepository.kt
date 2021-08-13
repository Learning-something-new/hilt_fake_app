package com.test.domain.books

import com.test.domain.entity.Book
import com.test.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun findBooks(query: String): Flow<Result<List<Book>>>

}