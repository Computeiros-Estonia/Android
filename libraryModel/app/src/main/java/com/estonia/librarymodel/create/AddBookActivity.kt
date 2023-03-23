package com.estonia.librarymodel.create

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details)

        val formTitle: EditText = findViewById(R.id.formsTitle)
        val formAuthor: EditText = findViewById(R.id.formsAuthor)
        val formPublisher: EditText = findViewById(R.id.formsPublisher)
        val formPublicationYear: EditText = findViewById(R.id.formsPublicationYear)

        // TODO - Aqui você deve recuperar o Dao que permite acessar a entidade Book

        val buttonCreate: Button = findViewById(R.id.buttonDone)
        buttonCreate.setOnClickListener {
            val newBook = Book(
                0,
                formTitle.text.toString(),
                formAuthor.text.toString(),
                formPublisher.text.toString(),
                formPublicationYear.text.toString()
            )
            CoroutineScope(Dispatchers.Main).launch {
                // TODO - Aqui você deve chamar o método do Dao que grava a entidade no banco
            }
            finish()
        }
    }
}