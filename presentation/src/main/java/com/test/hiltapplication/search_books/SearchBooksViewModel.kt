package com.test.hiltapplication.search_books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.books.FindBooksUseCase
import com.test.domain.entity.Book
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.test.domain.utils.Result

class SearchBooksViewModel(
    private val findBooksUseCase: FindBooksUseCase
) : ViewModel() {

    private val _books = MutableLiveData<Result<List<Book>>>()
    val books: LiveData<Result<List<Book>>>
        get() = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            findBooksUseCase(query).collect {
                _books.value = it
            }
        }
    }
}