package com.estonia.librarymodel.model.dto

import com.estonia.librarymodel.model.Book
import com.google.gson.annotations.SerializedName

data class DocDTO(
    @SerializedName("cover_i") val cover: Int,
    @SerializedName("has_fulltext") val hasFulltext: Boolean,
    @SerializedName("edition_count") val editionCount: Int,
    val title: String,
    @SerializedName("author_name") val authorName: List<String>?,
    @SerializedName("first_publish_year") val firstPublishYear: Int,
    @SerializedName("first_publisher") val firstPublisher: String,
    val key: String,
    val ia: List<String>,
    @SerializedName("author_key") val authorKey: List<String>
) {
    fun asBook(): Book {
        val author = if (authorName?.isNotEmpty() == true) {
            authorName[0]
        } else {
            "Unknown"
        }
        return Book(
            key,
            title = title,
            author = author,
            publisher = firstPublisher,
            publicationYear = firstPublishYear.toString()
        )
    }
}