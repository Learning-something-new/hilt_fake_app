package com.test.data.entity

import com.google.gson.annotations.SerializedName

data class BooksSearchResponse(
    val numFound: Int,
    @SerializedName("docs")
    val docBooks: List<DockBook>
)
