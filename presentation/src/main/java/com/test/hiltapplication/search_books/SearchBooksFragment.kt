package com.test.hiltapplication.search_books

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.test.data.books.BooksRepositoryImpl
import com.test.data.books.remote.BooksApiServiceImpl
import com.test.domain.books.FindBooksUseCase
import com.test.domain.utils.Result
import com.test.hiltapplication.databinding.FragmentSearchBooksBinding
import kotlinx.coroutines.Dispatchers

class SearchBooksFragment : Fragment() {

    private var _binding: FragmentSearchBooksBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchBooksViewModel by viewModels() {
        val booksApi = BooksApiServiceImpl()
        val findBooksUseCase = FindBooksUseCase(BooksRepositoryImpl(booksApi), Dispatchers.Default)
        SearchBooksViewModelFactory(findBooksUseCase)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBooksBinding.inflate(inflater, container, false)

        initRecycler()
        bindObservers()
        initViews()

        return binding.root
    }

    private fun initRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchBookRecyclerViewAdapter()
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }

    private fun bindObservers() {
        viewModel.books.observe(this.viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> binding.loading.visibility = View.VISIBLE
                is Result.Error -> {
                    Log.e("TAG", "bindObservers: ", result.exception)
                    showError(result.exception.message ?: "")
                    binding.loading.visibility = View.GONE
                }
                is Result.Success -> {
                    (binding.recycler.adapter as SearchBookRecyclerViewAdapter).setNewData(result.data)
                    binding.loading.visibility = View.GONE
                }
            }
        }
    }

    private fun initViews() {
        binding.search.setOnClickListener {
            val queryText = binding.searchField.text.toString()
            viewModel.searchBooks(queryText)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showError(msg: String) {
        Snackbar.make(requireView(), msg, Snackbar.LENGTH_INDEFINITE).setAction("DISMISS") {
        }.show()
    }
}