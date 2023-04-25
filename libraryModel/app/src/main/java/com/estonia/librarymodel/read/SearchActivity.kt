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

        // TODO - Você precisa recuperar o cliente retrofit para realizar chamadas em rede

        // TODO - Você precisa recuperar o serviço que permite acessar o endpoint remoto

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
                    // TODO - Aqui você deve usar o serviço para acessar a URL de busca,
                    // e converter o resultado para um objeto QueryResultDTO
                    val response: Response<QueryResultDTO>? = null
                    val results: QueryResultDTO? = null
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