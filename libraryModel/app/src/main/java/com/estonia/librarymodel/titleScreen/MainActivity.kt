package com.estonia.librarymodel.titleScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.estonia.librarymodel.R
import com.estonia.librarymodel.read.BookshelfActivity
import com.estonia.librarymodel.create.AddBookActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCreate:Button = findViewById(R.id.buttonCreate)
        buttonCreate.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBookActivity::class.java)
            startActivity(intent)
            //Toast.makeText(this@MainActivity, "Create!", Toast.LENGTH_SHORT).show()
        }
        val buttonRead:Button = findViewById(R.id.buttonRead)
        buttonRead.setOnClickListener{
            val intent = Intent(this@MainActivity, BookshelfActivity::class.java)
            startActivity(intent)
        }
    }

}