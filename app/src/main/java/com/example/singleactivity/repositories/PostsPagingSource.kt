package com.example.singleactivity.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.PageKeyedDataSource
import com.example.singleactivity.models.RedditListing
import com.example.singleactivity.models.RedditPost
import com.example.singleactivity.net.ApiClient
import com.example.singleactivity.net.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PostsPagingSource: PagingSource<String,RedditPost>() {
    private val apiService = ApiClient.getClient().create(ApiService::class.java)
    override fun getRefreshKey(state: PagingState<String, RedditPost>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPost> {
        return try {
            val response = apiService.getAllBest(loadSize = params.loadSize)
            val listing = response.body()?.data
            val redditPost = listing?.children?.map { it.data } //.children?.map {it.data}
            LoadResult.Page(
                redditPost ?: listOf(),
                listing?.before,
                listing?.after
            )
        }catch (e: IOException) {
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }


}