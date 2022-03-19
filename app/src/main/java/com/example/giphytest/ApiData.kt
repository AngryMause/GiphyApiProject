package com.example.giphytest

import com.google.gson.annotations.SerializedName


data class ApiData(
    @SerializedName("data")
    val data: List<Images>
)
data class Images(
    @SerializedName("images")
    val images: String,
    @SerializedName("downSizedMedium")
    val downSizedMedium: ImageUrl?
)
data class ImageUrl(
    @SerializedName("url")
    val url: String?
)


