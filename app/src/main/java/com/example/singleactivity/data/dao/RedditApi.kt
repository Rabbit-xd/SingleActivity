package com.example.singleactivity.data.dao

import com.example.singleactivity.modal.RedditModal
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET("best.json")
    suspend fun getBestPost(
        @Query("page") page:Int
    ): Response<RedditModal?>


    companion object {
        const val BASE_URL = "https://www.reddit.com/"
    }
}