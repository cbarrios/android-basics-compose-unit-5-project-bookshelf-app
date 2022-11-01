package com.lalosapps.bookshelfapp.data.network

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("imageLinks") val imageLinks: Thumbnails?
)