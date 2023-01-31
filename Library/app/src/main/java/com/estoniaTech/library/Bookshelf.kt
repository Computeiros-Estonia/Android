package com.estoniaTech.library

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Bookshelf: AppCompatActivity() {

    private lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

        val listView=findViewById<ListView>(R.id.estonianListView)
        val names = arrayOf("Memórias Póstumas de Bras Cubas", "O Cortiço", "Capitães da Areia", "A roga da Obediência")

        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = arrayAdapter
    }
}