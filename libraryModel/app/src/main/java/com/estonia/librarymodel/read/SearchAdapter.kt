package com.estonia.librarymodel.read

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.estonia.librarymodel.R
import com.estonia.librarymodel.model.dto.DocDTO
import com.estonia.librarymodel.model.room.RoomDatabaseInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var resultList: MutableList<DocDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.search_view_holder, parent, false)
        return SearchViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return if (resultList == null) {
            0
        } else {
            resultList!!.size
        }
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val book = resultList!![position]
        holder.bind(book)
    }

    fun setResultList(newBookList: List<DocDTO>) {
        resultList = newBookList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateResult(doc: DocDTO) {
        val index = resultList?.indexOf(doc) ?: -1
        if (index != -1) {
            notifyItemChanged(index)
        }
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val context = itemView.context

        private val titleText: TextView = itemView.findViewById(R.id.book_title)
        private val yearText: TextView = itemView.findViewById(R.id.book_year)
        private val addBookButton: ImageButton = itemView.findViewById(R.id.add_book_button)
        private val authorText: TextView = itemView.findViewById(R.id.book_author)
        private val publisherText: TextView = itemView.findViewById(R.id.book_publisher)

        private val compendiumDao = RoomDatabaseInstance.getInstance(context).getCompendiumDao()

        fun bind(doc: DocDTO) {
            val author = if (
                doc.authorName != null &&
                doc.authorName.isNotEmpty()
            ) {
                doc.authorName[0]
            } else
                "Unknown"

            titleText.text = doc.title
            yearText.text = doc.firstPublishYear.toString()
            authorText.text = author
            publisherText.text = doc.firstPublisher

            addBookButton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    compendiumDao.insert(doc.asBook())
                    this@SearchAdapter.updateResult(doc)
                }
            }

            CoroutineScope(Dispatchers.Main).launch {
                val book = compendiumDao.getBook(doc.key)
                val drawable = if (book == null) {
                    ResourcesCompat.getDrawable(context.resources, R.drawable.ic_add_24, context.theme) as Drawable
                } else {
                    ResourcesCompat.getDrawable(context.resources, R.drawable.ic_check_24, context.theme) as Drawable
                }
                addBookButton.setImageDrawable(drawable)
            }
        }
    }
}