package com.linecorp.serversidelayouting.data

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.linecorp.serversidelayouting.data.ScreenSectionLayoutType.GRID
import com.linecorp.serversidelayouting.data.ScreenSectionLayoutType.LIST
import java.lang.reflect.Type

class ScreenSectionTypeAdapter : JsonDeserializer<ScreenSection> {

    private val gson = Gson()

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ScreenSection {
        val screenSection = gson.fromJson(json, ScreenSection::class.java)

        val jsonObject = json.asJsonObject
        val layoutType = jsonObject.get("layoutType").asString

        val any = when (layoutType) {
            LIST.name -> processList(jsonObject)
            GRID.name -> processGrid(jsonObject)
            else -> processAny(jsonObject)
        }

        return screenSection.copy(
            data = any
        )
    }

    private fun processList(jsonObject: JsonObject): Any {
        val dataJsonObject = jsonObject.get("data").asJsonObject
        val type = object : TypeToken<TitleAndArticlesResponse>() {}.type
        return gson.fromJson(dataJsonObject, type)
    }

    private fun processGrid(jsonObject: JsonObject): Any {
        val dataJsonObject = jsonObject.get("data").asJsonArray
        val type = object : TypeToken<List<ArticleResponse>>() {}.type
        return gson.fromJson(dataJsonObject, type)
    }

    private fun processAny(jsonObject: JsonObject): Any {
        val dataJsonObject = jsonObject.get("data").asJsonObject
        val type = object : TypeToken<Any>() {}.type
        return gson.fromJson(dataJsonObject, type)
    }
}
