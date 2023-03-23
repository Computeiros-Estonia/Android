package com.estonia.librarymodel.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.estonia.librarymodel.model.Book

@Dao
interface CompendiumDao {
    @Query("SELECT * FROM Book ORDER BY uid DESC")
    fun getBookList(): LiveData<List<Book>>

    @Query("SELECT * FROM Book where uid = :bookUid ")
    suspend fun getBook(bookUid: Int): Book

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Delete
    suspend fun delete(book: Book)
}