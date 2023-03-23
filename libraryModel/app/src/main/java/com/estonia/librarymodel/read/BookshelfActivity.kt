package com.estonia.librarymodel.read

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.Book


class BookshelfActivity : AppCompatActivity() {

    private lateinit var bookList: LiveData<List<Book>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bookshelf)

        // TODO - Aqui você deve recuperar o Dao que permite acessar a entidade Book

        val bookRecyclerView: RecyclerView = findViewById(R.id.shelf_recyclerView)
        val bookshelfAdapter = BookshelfAdapter()
        bookRecyclerView.adapter = bookshelfAdapter

        // TODO - Aqui você deve chamar o método do Dao que faz a leitura da entidade no banco
        if (::bookList.isInitialized) {
            bookList.observe(this@BookshelfActivity) { list ->
                bookshelfAdapter.setBookList(list)
            }
        }
    }
}