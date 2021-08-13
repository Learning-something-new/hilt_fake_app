package com.test.hiltapplication.search_books

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.domain.entity.Book
import com.test.hiltapplication.databinding.ItemBookBinding


class SearchBookRecyclerViewAdapter(
    values: List<Book> = emptyList()
) : RecyclerView.Adapter<SearchBookRecyclerViewAdapter.ViewHolder>() {

    private val values = values.toMutableList()

    fun setNewData(items: List<Book>){
        values.clear()
        values.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        private val titleView: TextView = binding.title
        private val authorView: TextView = binding.author

        fun bind(item: Book) {
            titleView.text = item.title
            authorView.text = item.author
        }
    }

}