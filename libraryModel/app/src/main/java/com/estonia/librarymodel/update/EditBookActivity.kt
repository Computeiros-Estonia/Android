package com.estonia.librarymodel.update

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditBookActivity: AppCompatActivity() {

    private var bookIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details)

        bookIndex = intent.getIntExtra(BOOK_INDEX, -1)
        if (bookIndex == -1) {
            finish()
        }

        val formTitle: EditText = findViewById(R.id.formsTitle)
        val formAuthor: EditText = findViewById(R.id.formsAuthor)
        val formPublisher: EditText = findViewById(R.id.formsPublisher)
        val formPublicationYear: EditText = findViewById(R.id.formsPublicationYear)

        // TODO - Aqui você deve recuperar o Dao que permite acessar a entidade Book

        val buttonEdit: Button = findViewById(R.id.buttonDone)
        buttonEdit.setOnClickListener {
            val newBook = Book(
                bookIndex,
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

        CoroutineScope(Dispatchers.Main).launch {
            // TODO - Aqui você deve chamar o método do Dao que faz a leitura da entidade no banco
            val book = Book()

            formTitle.setText(book.titulo)
            formAuthor.setText(book.autor)
            formPublisher.setText(book.editora)
            formPublicationYear.setText(book.ano)
        }
    }

    companion object {
        const val BOOK_INDEX = "BOOK_INDEX"
    }
}