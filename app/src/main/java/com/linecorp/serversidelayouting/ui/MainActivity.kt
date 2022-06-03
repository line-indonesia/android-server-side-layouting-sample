package com.linecorp.serversidelayouting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.linecorp.serversidelayouting.R
import com.linecorp.serversidelayouting.data.StubResponseCreator
import com.linecorp.serversidelayouting.data.ViewItemStubRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
    }

    private fun initList() {
        val json = StubResponseCreator.getScreenSectionListJson()
        val repository = ViewItemStubRepository()
        val viewItems = repository.getViewItems(json)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = ViewItemAdapter(viewItems)
    }
}
