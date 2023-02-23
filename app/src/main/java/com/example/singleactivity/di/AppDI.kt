package com.example.singleactivity.di

import com.example.singleactivity.data.dao.RedditApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDI {

    @Provides
    fun provideBaseUrl() = RedditApi.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String):RedditApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RedditApi::class.java)

}