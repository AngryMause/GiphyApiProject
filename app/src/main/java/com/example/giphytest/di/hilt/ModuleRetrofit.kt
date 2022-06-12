package com.example.giphytest.di.hilt

import com.example.giphytest.MainRepository
import com.example.giphytest.api.MainService
import com.example.giphytest.api.RestClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleRetrofit {

    @Provides
    fun provideBaseUrl():String= RestClient.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL:String)=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        @Provides
        @Singleton
        fun provideGiphyApi(retrofit: Retrofit): MainService = retrofit.create(MainService::class.java)

        @Provides
        @Singleton
        fun provideGiphyApiImp(giphyApi: MainService ) :MainRepository= MainRepository(giphyApi,)

}