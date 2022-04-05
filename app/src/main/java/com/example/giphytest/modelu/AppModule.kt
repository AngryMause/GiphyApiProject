package com.example.giphytest.modelu

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.giphytest.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ServiceComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGlide(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions().placeholder(R.drawable.ic_tatto)
            .error(R.drawable.ic_tatto2)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

}