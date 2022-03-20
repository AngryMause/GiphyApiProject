package com.example.giphytest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GiphyApi {
    @GET(RestClient.API_KEY)
    suspend fun getList(): ApiData
}

object GiphyApiImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl(RestClient.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val giphyService = retrofit.create(GiphyApi::class.java)

    suspend fun getListOfGif(): List<ImageModel> {
        return withContext(Dispatchers.IO) {
            giphyService.getList().data
                .map { data ->
                    ImageModel(data.images.downSizedMedium?.url)
                }

        }

    }


}