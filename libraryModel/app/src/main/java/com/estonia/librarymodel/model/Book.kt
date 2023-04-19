package com.estonia.librarymodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "Titulo") var title: String? = null,
    @ColumnInfo(name = "Autor") var author: String? = null,
    @ColumnInfo(name = "Editora") var publisher: String? = null,
    @ColumnInfo(name = "Ano") var publicationYear: String? = null
)