package com.test.data.mapper

import com.test.data.entity.DockBook
import com.test.domain.entity.Book
import com.test.domain.mapper.Mapper

object BooksToPresentationMapper: Mapper<DockBook, Book> {

    override fun convert(obj: DockBook): Book {
       return Book(
           authors = obj.authors!!,
           title = obj.title,
           subtitle = obj.subtitle ?: "",
           imageUrl = constructImageUrl(obj.coverId)
       )
    }

    private fun constructImageUrl(coverId: Int): String {
        return "http://covers.openlibrary.org/b/id/$coverId-S.jpg"
    }

}