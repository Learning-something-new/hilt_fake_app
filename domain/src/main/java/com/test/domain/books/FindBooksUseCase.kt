package com.test.domain.books

import com.test.domain.di.DefaultDispatcher
import com.test.domain.entity.Book
import com.test.domain.usecase.FlowUseCase
import com.test.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindBooksUseCase @Inject constructor(
    private val booksRepository: BooksRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<String, List<Book>>(dispatcher) {

    override fun execute(parameters: String): Flow<Result<List<Book>>> {
        return booksRepository.findBooks(parameters)
    }

}