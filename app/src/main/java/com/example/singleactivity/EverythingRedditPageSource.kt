package com.example.singleactivity
/**
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import retrofit2.http.Query

class EverythingRedditPageSource(
    private val redditService: RedditService,
    private val query: String

): PagingSource<Int, Article>() {


    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        if (query.isEmpty()){
            return LoadResult.Page(emptyList(),prevKey = null,nextKey = null)
        }
        val page : Int = params.key?:1
        val pageSize: Int = params.loadSize.coerceAtMost(RedditService.MAX_PAGE_SIZE)

        val response = redditService.everything(query,page,pageSize)
        if (response.isSuccessful){
            val articles = checkNotNull(response.body()).articles.map{it.toArticle}
            val nextKey = if (articles.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(articles,nextKey,prevKey)
        }else{
            return LoadResult.Error(HttpException(response))
        }

    }
}
        **/