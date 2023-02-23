package com.example.singleactivity.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.singleactivity.data.dao.RedditApi
import com.example.singleactivity.modal.ChildrenDataModal
import com.example.singleactivity.modal.ChildrenModal
import com.example.singleactivity.modal.DataModal


class RedditPostPagingSource(
    private val redditApiService: RedditApi
    ):PagingSource<Int, ChildrenModal>(){
    override fun getRefreshKey(state: PagingState<Int, ChildrenModal>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ChildrenModal> {
        return try {
            val currentPage = params.key?:1
            val responce = redditApiService.getBestPost(currentPage)
            val data = responce.body()?.data?: emptyList()
            val responseData = mutableListOf<ChildrenModal>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}