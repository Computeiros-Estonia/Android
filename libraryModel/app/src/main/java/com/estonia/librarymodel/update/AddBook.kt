package com.estonia.librarymodel.update

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.estonia.librarymodel.R
import com.estonia.librarymodel.read.Bookshelf

class AddBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_book)

        val buttonCreate: Button = findViewById(R.id.buttonDone)
        buttonCreate.setOnClickListener{
            val intent = Intent(this@AddBook, Bookshelf::class.java)
            startActivity(intent)
        }
    }
}