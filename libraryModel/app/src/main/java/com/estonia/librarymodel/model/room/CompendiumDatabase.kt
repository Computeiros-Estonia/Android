package com.estonia.librarymodel.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.estonia.librarymodel.model.Book

@Database(entities = [Book::class], version = 2)
abstract class CompendiumDatabase : RoomDatabase() {

    abstract fun getCompendiumDao(): CompendiumDao
}