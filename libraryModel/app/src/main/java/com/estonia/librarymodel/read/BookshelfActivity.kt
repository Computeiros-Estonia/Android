package com.estonia.librarymodel.read

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.Book
import com.estonia.librarymodel.model.room.RoomDatabaseInstance


class BookshelfActivity : AppCompatActivity() {

    private lateinit var bookList: LiveData<List<Book>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bookshelf)

        val compendiumDao = RoomDatabaseInstance.getInstance(this).getCompendiumDao()

        val bookRecyclerView: RecyclerView = findViewById(R.id.shelf_recyclerView)
        val bookshelfAdapter = BookshelfAdapter()
        bookRecyclerView.adapter = bookshelfAdapter

        bookList = compendiumDao.getBookList()
        if (::bookList.isInitialized) {
            bookList.observe(this@BookshelfActivity) { list ->
                bookshelfAdapter.setBookList(list)
            }
        }
    }
}