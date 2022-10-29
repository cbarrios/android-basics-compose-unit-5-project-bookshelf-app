package com.lalosapps.bookshelfapp.data.network

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("thumbnail") val thumbnail: String
) {
    val httpsThumbnail: String
        get() = thumbnail.replace("http", "https")
}