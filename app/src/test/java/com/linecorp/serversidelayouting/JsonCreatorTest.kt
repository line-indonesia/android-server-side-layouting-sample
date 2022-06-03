package com.linecorp.serversidelayouting

import com.google.gson.Gson
import com.linecorp.serversidelayouting.data.ArticleResponse
import com.linecorp.serversidelayouting.data.ScreenSection
import com.linecorp.serversidelayouting.data.ScreenSectionLayoutType
import com.linecorp.serversidelayouting.data.TitleAndArticlesResponse
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class JsonCreatorTest {

    @Test
    fun createJson() {
        // Given
        val articleList = listOf(
            ArticleResponse("Title 1", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 2", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 3", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0),
            ArticleResponse("Title 4", "thumbnail hash", 0, "articleHash", "publisher", 0L, 0)
        )
        val titleAndArticleResponse = TitleAndArticlesResponse(
            "#title",
            articleList
        )

        // When
        val screenSection = ScreenSection(ScreenSectionLayoutType.LIST, titleAndArticleResponse)
        val json = Gson().toJson(screenSection)

        // Then
        assertNotNull(json)
    }
}
