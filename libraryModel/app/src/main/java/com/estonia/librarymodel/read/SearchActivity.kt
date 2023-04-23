package com.estonia.librarymodel.read

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.dto.QueryResultDTO
import com.estonia.librarymodel.network.RetrofitClient
import com.estonia.librarymodel.network.SearchService
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.URLEncoder

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchEditText = findViewById<TextInputEditText>(R.id.search_edit_text)

        val retrofitInstance = RetrofitClient.getRetrofitInstance()
        val searchService = retrofitInstance.create(SearchService::class.java)

        val searchResultsRecyclerView = findViewById<RecyclerView>(R.id.search_results)
        val searchAdapter = SearchAdapter()
        searchResultsRecyclerView.adapter = searchAdapter

        val loadingSpinner = findViewById<ProgressBar>(R.id.loading_symbol)

        val executeButton = findViewById<ImageButton>(R.id.execute_button)
        executeButton.setOnClickListener {
            val queryInput = searchEditText.text.toString().trim()
            if (queryInput.isEmpty()) {
                Toast.makeText(this@SearchActivity, "Sem dados a consultar", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            CoroutineScope(Dispatchers.Main).launch {
                loadingSpinner.visibility = View.VISIBLE
                withContext(Dispatchers.IO) {
                    val queryUrl = URLEncoder.encode(queryInput, "UTF-8")
                    val response: Response<QueryResultDTO> = searchService.searchQuery(queryUrl)
                    val results: QueryResultDTO? = response.body()
                    results?.let {
                        withContext(Dispatchers.Main) {
                            searchAdapter.setResultList(results.docs)
                        }
                    }
                }
                withContext(Dispatchers.Main) {
                    loadingSpinner.visibility = View.GONE
                }
            }
        }
    }
}