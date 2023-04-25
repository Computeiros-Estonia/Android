package com.estonia.librarymodel.titleScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.estonia.librarymodel.R
import com.estonia.librarymodel.read.BookshelfActivity
import com.estonia.librarymodel.read.SearchActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch = findViewById<Button>(R.id.button_search)
        buttonSearch.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(intent)
        }
        val buttonRead:Button = findViewById(R.id.button_read)
        buttonRead.setOnClickListener {
            val intent = Intent(this@MainActivity, BookshelfActivity::class.java)
            startActivity(intent)
        }
    }

}