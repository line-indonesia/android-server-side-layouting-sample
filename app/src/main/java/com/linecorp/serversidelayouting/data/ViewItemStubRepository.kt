package com.linecorp.serversidelayouting.data

import androidx.annotation.VisibleForTesting
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.linecorp.serversidelayouting.domain.*

class ViewItemStubRepository : ViewItemRepository {

    private val deserializer = ScreenSectionTypeAdapter()

    private val gson = GsonBuilder().registerTypeAdapter(
        ScreenSection::class.java,
        deserializer
    ).create()

    override fun getViewItems(json: String): List<ViewItem> {
        val token = object : TypeToken<List<ScreenSection>>() {}.type
        val screenSectionList = gson.fromJson<List<ScreenSection>>(
            json,
            token
        )
        return convertScreenSectionToViewItem(screenSectionList)
    }

    @VisibleForTesting
    fun convertScreenSectionToViewItem(screenSectionList: List<ScreenSection>): List<ViewItem> {
        return screenSectionList.map { section ->
            when (section.layoutType) {
                ScreenSectionLayoutType.DIVIDER -> DividerViewItem()
                ScreenSectionLayoutType.GRID -> getGridViewItem(section.data)
                ScreenSectionLayoutType.LIST -> getListViewItem(section.data)
            }
        }
    }

    private fun getGridViewItem(data: Any): GridViewItem {
        return GridViewItem(
            articleList = data as List<ArticleResponse>
        )
    }

    private fun getListViewItem(data: Any): ListViewItem {
        val titleAndArticlesResponse: TitleAndArticlesResponse = data as TitleAndArticlesResponse
        return ListViewItem(
            title = titleAndArticlesResponse.title,
            articleList = titleAndArticlesResponse.articleList
        )
    }
}
