package com.linecorp.serversidelayouting.data

data class ScreenSection(
    val layoutType: ScreenSectionLayoutType,
    val data: Any = Any()
)

enum class ScreenSectionLayoutType {
    DIVIDER,
    LIST,
    GRID
}

