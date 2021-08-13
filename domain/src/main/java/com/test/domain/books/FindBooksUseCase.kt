package com.test.domain.books

import com.test.domain.entity.Book
import com.test.domain.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import com.test.domain.utils.Result

class FindBooksUseCase(
    private val booksRepository: BooksRepository,
    dispatcher: CoroutineDispatcher
) : FlowUseCase<String, List<Book>>(dispatcher) {

    override fun execute(parameters: String): Flow<Result<List<Book>>> {
        return booksRepository.findBooks(parameters)
    }

}