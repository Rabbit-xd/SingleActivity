package com.example.singleactivity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.singleactivity.data.dao.RedditApi
import com.example.singleactivity.paging.RedditPostPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel()
class RedditPostViewModel
@Inject constructor(private val redditApiService: RedditApi): ViewModel(){

    val listData = Pager(PagingConfig(
        pageSize = 1
        )){
        RedditPostPagingSource(redditApiService)
    }.flow.cachedIn(viewModelScope)
}