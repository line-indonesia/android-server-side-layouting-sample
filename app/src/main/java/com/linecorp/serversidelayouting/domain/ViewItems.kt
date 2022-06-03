package com.linecorp.serversidelayouting.domain

import com.linecorp.serversidelayouting.data.ArticleResponse
import com.linecorp.serversidelayouting.data.ScreenSectionLayoutType

sealed class ViewItem {
    abstract val layoutType: ScreenSectionLayoutType
}

data class DividerViewItem(
    override val layoutType: ScreenSectionLayoutType = ScreenSectionLayoutType.DIVIDER
) : ViewItem()

data class ListViewItem(
    override val layoutType: ScreenSectionLayoutType = ScreenSectionLayoutType.LIST,

    val title: String,
    val articleList: List<ArticleResponse>
) : ViewItem()

data class GridViewItem(
    override val layoutType: ScreenSectionLayoutType = ScreenSectionLayoutType.GRID,

    val articleList: List<ArticleResponse>
) : ViewItem()
