package com.linecorp.serversidelayouting.data

import com.google.gson.Gson

object StubResponseCreator {

    val gson = Gson()

    fun getScreenSectionListJson(): String {
        return gson.toJson(getScreenSectionList())
    }

    fun getScreenSectionList(): List<ScreenSection> {
        return listOf(
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.LIST, getTitleAndArticleResponseData()),
            ScreenSection(ScreenSectionLayoutType.GRID, getArticleListData()),
            ScreenSection(ScreenSectionLayoutType.DIVIDER)
        )
    }

    private fun getTitleAndArticleResponseData(): Any {
        val articleList = listOf(
            ArticleResponse("Title 1", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 2", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 3", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 4", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0)
        )
        return TitleAndArticlesResponse(
            "#title",
            articleList
        )
    }

    private fun getArticleListData(): Any {
        return listOf(
            ArticleResponse("Title 1", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 2", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 3", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 4", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0)
        )
    }
}
