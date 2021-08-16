package com.test.hiltapplication.di

import com.test.domain.books.BooksRepository
import com.test.domain.books.FindBooksUseCase
import com.test.domain.entity.Book
import com.test.domain.usecase.FlowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesDIModule {

    @Provides
    @ViewModelScoped
    fun bindFindBooksUseCase(
        booksRepository: BooksRepository,
        dispatcher: CoroutineDispatcher = Dispatchers.Default
    ): FlowUseCase<String, List<Book>> = FindBooksUseCase(booksRepository, dispatcher)
}