package com.example.giphytest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GiphyApi {
    @GET("/v1/gifs/trending?api_key=WEuIQopgJU7vujIMCLTnp5NTVbAc4pxV&limit=10&rating=g")
    suspend fun getList(): ApiData
}


object GiphyApiImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.giphy.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val giphyServise = retrofit.create(GiphyApi::class.java)

    suspend fun getListOfGif(): List<ImageModel> {
        return withContext(Dispatchers.IO) {
            giphyServise.getList().data
                .map { data ->
                    ImageModel(data.images.downSizedMedium?.url)
                }


        }

    }


}