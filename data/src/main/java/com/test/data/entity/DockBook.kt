package com.test.data.entity

import com.google.gson.annotations.SerializedName

data class DockBook(
    val key: String,
    val title: String,
//    @SerializedName("author_name")
    val author: String = "author noname",
    @SerializedName("cover_i")
    val coverId: Int,
    val subtitle: String = ""
)
