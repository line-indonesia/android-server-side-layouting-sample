package com.linecorp.serversidelayouting.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.linecorp.serversidelayouting.R
import com.linecorp.serversidelayouting.domain.DividerViewItem
import com.linecorp.serversidelayouting.domain.GridViewItem
import com.linecorp.serversidelayouting.domain.ListViewItem
import com.linecorp.serversidelayouting.domain.ViewItem

sealed class ScreenSectionViewHolder<in T : ViewItem>(
    parent: ViewGroup,
    layoutId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    abstract fun bind(viewItem: T)
}

class DividerViewHolder(
    parent: ViewGroup
) : ScreenSectionViewHolder<DividerViewItem>(parent, R.layout.item_divider) {

    override fun bind(viewItem: DividerViewItem) {
        // Divider don't need any data
    }
}

class ListViewHolder(
    parent: ViewGroup
) : ScreenSectionViewHolder<ListViewItem>(parent, R.layout.item_list) {

    private val textViewTitle = itemView.findViewById<TextView>(R.id.textViewTitle)
    private val textViewData = itemView.findViewById<TextView>(R.id.textViewData)

    override fun bind(viewItem: ListViewItem) {
        textViewTitle.text = viewItem.title
        val articles = viewItem.articleList.map { " " + it.title + " " }.toString()
        textViewData.text = articles
    }
}

class GridViewHolder(
    parent: ViewGroup
) : ScreenSectionViewHolder<GridViewItem>(parent, R.layout.item_grid) {

    private val textViewData = itemView.findViewById<TextView>(R.id.textViewData)

    override fun bind(viewItem: GridViewItem) {
        val articles = viewItem.articleList.map { " " + it.title + " \n" }.toString()
        textViewData.text = articles
    }
}
