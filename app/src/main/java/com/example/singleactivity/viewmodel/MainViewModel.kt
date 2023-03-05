package com.example.singleactivity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.singleactivity.models.RedditPost
//import com.example.singleactivity.repositories.PostsDataSource
import com.example.singleactivity.repositories.PostsPagingSource
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    // var postsLiveData: LiveData<PagedList<RedditPost>>
    val flow = Pager(
        PagingConfig(pageSize = 20, enablePlaceholders = false)
    ){
        PostsPagingSource()
    }.flow.cachedIn(viewModelScope)
/**
    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()
        postsLiveData = initializedPagedListBuilder(config).build()
    }
    **/
/**
    fun getPosts(): LiveData<PagedList<RedditPost>> = postsLiveData

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<String,RedditPost> {
        val dataSourceFactory = object : DataSource.Factory<String, RedditPost>() {
            override fun create(): DataSource<String, RedditPost> {
                return PostsDataSource(Dispatchers.IO)
            }

        }
        return LivePagedListBuilder<String,RedditPost>(dataSourceFactory,config)
    }
**/
}