package com.example.giphytest

import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class ApiData(
    val data: List<Result>
)


data class Result(
    val image: String,
    val downSizedMedium: ImageUrl?
)


data class ImageUrl(
    val url: String?
)
