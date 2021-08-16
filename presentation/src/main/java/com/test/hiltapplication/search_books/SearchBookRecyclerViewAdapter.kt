package com.test.hiltapplication.search_books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.domain.entity.Book
import com.test.hiltapplication.R
import com.test.hiltapplication.databinding.ItemBookBinding


class SearchBookRecyclerViewAdapter(
    values: List<Book> = emptyList()
) : RecyclerView.Adapter<SearchBookRecyclerViewAdapter.ViewHolder>() {

    private val values = values.toMutableList()

    fun setNewData(items: List<Book>) {
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

    inner class ViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book) {
            Glide.with(binding.root)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_loading_placeholder)
                .into(binding.image)

            binding.title.text = item.title
            binding.author.text = item.authors.joinToString(separator = ", ")
        }
    }

}