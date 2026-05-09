package com.example.oaxacalibrerocultural.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookShelfResponse(
    @SerialName("items")
    val items: List<Book> = emptyList()
)

@Serializable
data class Book(
    val id: String,
    @SerialName("volumeInfo")
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String = "",
    @SerialName("imageLinks")
    val imageLinks: ImageLinks? = null,
    @SerialName("infoLink")
    val infoLink: String = ""
)

@Serializable
data class ImageLinks(
    @SerialName("thumbnail")
    val thumbnail: String = ""
)
