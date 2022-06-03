package com.linecorp.serversidelayouting.domain

interface ViewItemRepository {

    fun getViewItems(json: String): List<ViewItem>
}
