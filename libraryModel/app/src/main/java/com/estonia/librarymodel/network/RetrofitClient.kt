package com.estonia.librarymodel.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val BASE_URL: String = "https://openlibrary.org/"
        private var retrofitClient: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            if (retrofitClient == null) {
                retrofitClient = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitClient as Retrofit
        }
    }
}