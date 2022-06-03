package com.linecorp.serversidelayouting

import com.linecorp.serversidelayouting.data.StubResponseCreator
import com.linecorp.serversidelayouting.data.ViewItemStubRepository
import com.linecorp.serversidelayouting.domain.DividerViewItem
import com.linecorp.serversidelayouting.domain.GridViewItem
import com.linecorp.serversidelayouting.domain.ListViewItem
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ConversionTest {

    @Test
    fun jsonToViewItem() {
        // Given
        val json = ResponseJson.get()
        val repository = ViewItemStubRepository()

        // When
        val viewItems = repository.getViewItems(json)

        // Then - Correct View Item
        assertTrue(viewItems.first() is DividerViewItem)
        assertTrue(viewItems[1] is ListViewItem)
        assertTrue(viewItems[2] is DividerViewItem)
        assertTrue(viewItems[3] is GridViewItem)

        // Then - Correct Data Type 1
        val listViewItem = viewItems[1] as ListViewItem
        assertTrue(listViewItem.title == "#title")
        assertTrue(listViewItem.articleList.first().title == "Title 1")

        // Then - Correct Data Type 2
        val gridViewItem = viewItems[3] as GridViewItem
        assertTrue(gridViewItem.articleList.first().title == "Title 1")
    }

    @Test
    fun screenSectionListToViewItem() {
        // Given
        val screenSectionList = StubResponseCreator.getScreenSectionList()
        val repository = ViewItemStubRepository()

        // When
        val viewItems = repository.convertScreenSectionToViewItem(screenSectionList)

        // Then - Correct View Item
        assertTrue(viewItems.first() is DividerViewItem)
        assertTrue(viewItems[1] is ListViewItem)
        assertTrue(viewItems[2] is DividerViewItem)
        assertTrue(viewItems[3] is GridViewItem)

        // Then - Correct Data Type 1
        val listViewItem = viewItems[1] as ListViewItem
        assertTrue(listViewItem.title == "#title")
        assertTrue(listViewItem.articleList.first().title == "Title 1")

        // Then - Correct Data Type 2
        val gridViewItem = viewItems[3] as GridViewItem
        assertTrue(gridViewItem.articleList.first().title == "Title 1")
    }
}
