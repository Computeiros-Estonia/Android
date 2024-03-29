package com.estonia.librarymodel.read

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.Book
import com.estonia.librarymodel.model.room.RoomDatabaseInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookshelfAdapter: RecyclerView.Adapter<BookshelfAdapter.BookViewHolder>() {

    private var bookList: MutableList<Book>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.book_view_holder, parent, false)
        return BookViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return if (bookList == null) {
            0
        } else {
            bookList!!.size
        }
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList!![position]
        holder.bind(book)
    }

    fun setBookList(newBookList: List<Book>) {
        bookList = newBookList.toMutableList()
        notifyDataSetChanged()
    }

    private fun removeBook(bookToRemove: Book) {
        val index = bookList?.indexOf(bookToRemove) ?: -1
        if (index != -1) {
            bookList!!.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleText: TextView = itemView.findViewById(R.id.book_title)
        private val yearText: TextView = itemView.findViewById(R.id.book_year)
        private val deleteButton: ImageView = itemView.findViewById(R.id.delete_book_button)
        private val authorText: TextView = itemView.findViewById(R.id.book_author)
        private val publisherText: TextView = itemView.findViewById(R.id.book_publisher)

        private val compendiumDao = RoomDatabaseInstance.getInstance(itemView.context).getCompendiumDao()

        fun bind(book: Book) {
            titleText.text = book.title
            yearText.text = book.publicationYear
            authorText.text = book.author
            publisherText.text = book.publisher

            deleteButton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    compendiumDao.delete(book)
                    this@BookshelfAdapter.removeBook(book)
                }
            }
        }
    }
}