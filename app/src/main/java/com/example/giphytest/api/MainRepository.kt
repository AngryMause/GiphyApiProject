package com.example.giphytest

import com.example.giphytest.api.MainService
import com.example.giphytest.model.ImageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainRepository @Inject constructor(private val giphyApi: MainService) {

    suspend fun getListOfGif(): List<ImageModel> {
        return withContext(Dispatchers.IO) {
            giphyApi.getList().data
                .map { data ->
                    ImageModel(data.images.downsized?.url)
                }
        }
    }
}