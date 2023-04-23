package com.estonia.librarymodel.network

import com.estonia.librarymodel.model.dto.QueryResultDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("search.json")
    suspend fun searchQuery(@Query("q") query: String) : Response<QueryResultDTO>
}