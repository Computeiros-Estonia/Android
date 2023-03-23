package com.estonia.librarymodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book (
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "titulo") var titulo: String? = null,
    @ColumnInfo(name = "autor") var autor: String? = null,
    @ColumnInfo(name = "editora") var editora: String? = null,
    @ColumnInfo(name = "ano") var ano: String? = null
)