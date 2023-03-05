package com.example.singleactivity.net
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import com.example.singleactivity.models.Post
import com.example.singleactivity.models.RedditApiResponse
import com.example.singleactivity.models.detail.DetailPostResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("best/.json")
    suspend fun getAllBest(
        @Query("limit") loadSize: Int = 20,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ):Response<RedditApiResponse>

    @GET("best/{id}.json")
    suspend fun getPostDetail(@Query("id") id :String?): Response<DetailPostResponse>
}