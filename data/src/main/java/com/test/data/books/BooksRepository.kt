package com.test.data.books

import com.test.data.books.remote.BooksApi
import com.test.data.books.remote.BooksApiServiceImpl
import com.test.domain.books.BooksRepository
import com.test.domain.entity.Book
import kotlinx.coroutines.flow.Flow
import com.test.domain.utils.Result
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksApi: BooksApiServiceImpl
): BooksRepository {

    override fun findBooks(query: String): Flow<Result<List<Book>>> {
        return flow {
            emit(Result.Loading)

            val result = booksApi.searchBooks(query)
            emit(Result.Success(result))
        }
    }

}