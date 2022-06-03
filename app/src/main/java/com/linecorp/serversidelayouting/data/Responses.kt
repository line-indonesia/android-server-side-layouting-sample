package com.linecorp.serversidelayouting.data

data class ArticleResponse(
    val title: String = "",
    val thumbnailHash: String = "",
    val articleId: Long = 0L,
    val articleHash: String = "",
    val publisher: String = "",
    val publishTime: Long = 0L,
    val commentCount: Int = 0
)

data class TitleAndArticlesResponse(
    val title: String = "",
    val articleList: List<ArticleResponse> = listOf()
)
