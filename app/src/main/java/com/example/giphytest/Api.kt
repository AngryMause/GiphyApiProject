package com.example.giphytest

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GiphyApi {
    @GET("./v1/gifs/trending?api_key=WEuIQopgJU7vujIMCLTnp5NTVbAc4pxV&limit=5&rating=g")
    suspend fun getList(): ApiData
}


object GiphyApiImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.giphy.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val giphyServise = retrofit.create(GiphyApi::class.java)

    suspend fun getListOfGif(): List<GiphyModel> {
        return withContext(Dispatchers.IO) {
            giphyServise.getList().data.map { image ->               
                GiphyModel(image.downSizedMedium?.url)
            }
        }
    }


}


