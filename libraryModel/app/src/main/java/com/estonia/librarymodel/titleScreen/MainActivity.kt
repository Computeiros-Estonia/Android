package com.estonia.librarymodel.titleScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.estonia.librarymodel.R
import com.estonia.librarymodel.update.AddBook

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCreate:Button = findViewById(R.id.buttonCreate)
        buttonCreate.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBook::class.java)
            startActivity(intent)
            //Toast.makeText(this@MainActivity, "Create!", Toast.LENGTH_SHORT).show()
        }
        val buttonRead:Button = findViewById(R.id.buttonRead)
        buttonRead.setOnClickListener{
        }
        val buttonUpdate:Button = findViewById(R.id.buttonUpdate)
        buttonUpdate.setOnClickListener{
            Toast.makeText(this@MainActivity, "Update!", Toast.LENGTH_SHORT).show()
        }
        val buttonDelete:Button = findViewById(R.id.buttonDelete)
        buttonDelete.setOnClickListener{
            Toast.makeText(this@MainActivity, "Delete!", Toast.LENGTH_SHORT).show()
        }
    }

}