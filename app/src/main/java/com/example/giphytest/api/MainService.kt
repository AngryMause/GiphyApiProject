package com.example.giphytest.api

import com.example.giphytest.ApiData
import retrofit2.http.GET

interface MainService {
    @GET(RestClient.API_KEY)
    suspend fun getList():ApiData
}