package com.test.hiltapplication.di

import com.test.data.books.BooksRepositoryImpl
import com.test.domain.books.BooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryDIModule {

    @Binds
    @ActivityScoped
    abstract fun bindBooksRepository(
        booksRepository: BooksRepositoryImpl
    ): BooksRepository
}