package com.test.hiltapplication.search_books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.domain.books.FindBooksUseCase

class SearchBooksViewModelFactory(
    private val findBooksUseCase: FindBooksUseCase
): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchBooksViewModel::class.java)) {
            return SearchBooksViewModel(findBooksUseCase) as T
        }
        throw Exception("Not SearchBooksViewModel")
    }
}