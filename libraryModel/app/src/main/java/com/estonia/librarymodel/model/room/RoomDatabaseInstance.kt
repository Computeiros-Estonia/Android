package com.estonia.librarymodel.model.room

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class RoomDatabaseInstance {

    companion object {
        private var database: CompendiumDatabase? = null

        // TODO - É preciso criar um objeto de migração aqui

        fun getInstance(applicationContext: Context): CompendiumDatabase {
            if (database == null) {
                // TODO - É preciso adicionar o objeto de migração aqui
                database = Room.databaseBuilder(
                    applicationContext,
                    CompendiumDatabase::class.java,
                    "ToDoList-Database"
                )
                    .build()
            }
            return database as CompendiumDatabase
        }
    }
}