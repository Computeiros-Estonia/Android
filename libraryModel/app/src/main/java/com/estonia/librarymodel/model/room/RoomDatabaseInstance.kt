package com.estonia.librarymodel.model.room

import android.content.Context
import androidx.room.Room

class RoomDatabaseInstance {

    companion object {
        private var database: CompendiumDatabase? = null

        fun getInstance(applicationContext: Context): CompendiumDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    applicationContext,
                    CompendiumDatabase::class.java,
                    "ToDoList-Database"
                ).build()
            }
            return database as CompendiumDatabase
        }
    }
}