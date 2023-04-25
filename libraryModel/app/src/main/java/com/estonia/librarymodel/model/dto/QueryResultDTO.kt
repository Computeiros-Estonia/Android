package com.estonia.librarymodel.model.dto

data class QueryResultDTO(
    val start: Double,
    val numFound: Double,
    val docs: List<DocDTO>
)