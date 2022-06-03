package com.linecorp.serversidelayouting.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linecorp.serversidelayouting.data.ScreenSectionLayoutType
import com.linecorp.serversidelayouting.domain.ViewItem

class ViewItemAdapter(
    private val viewItems: List<ViewItem>
) : RecyclerView.Adapter<ScreenSectionViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenSectionViewHolder<*> {
        val layoutType = ScreenSectionLayoutType.values()[viewType]
        return when (layoutType) {
            ScreenSectionLayoutType.DIVIDER -> DividerViewHolder(parent)
            ScreenSectionLayoutType.LIST -> ListViewHolder(parent)
            ScreenSectionLayoutType.GRID -> GridViewHolder(parent)
        }
    }

    override fun getItemCount(): Int = viewItems.size

    override fun getItemViewType(position: Int): Int = viewItems[position].layoutType.ordinal

    override fun onBindViewHolder(holder: ScreenSectionViewHolder<*>, position: Int) {
        val viewItem = viewItems[position]
        (holder as ScreenSectionViewHolder<ViewItem>).bind(viewItem)
    }
}
