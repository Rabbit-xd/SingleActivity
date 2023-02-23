package com.example.singleactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.singleactivity.modal.RedditModal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
/**
class MainViewModel(
    private val redditsRepository: RedditsRepository
): ViewModel() {
    val isErrorsEnabled: Flow<Boolean> = redditsRepository.isErrorsEnabled()
    val redditFlow: Flow<PagingData<RedditModal>>
    private val searchBy = MutableLiveData("")

    init {
        redditFlow = searchBy.asFlow()
            .debounce(500)
            .flatMapLatest {
                redditsRepository.getPagedReddits(it)
            }
            .cachedIn(viewModelScope)
    }

    fun setSearchBy(value: String) {
        if(this.searchBy.value == value) return
        this.searchBy.value = value
    }

    fun refresh(){
        this.searchBy.postValue(this.searchBy.value)
    }

    fun setEnableErrors(value: Boolean){
        redditsRepository.setErrorEnabled(value)
    }

}
        **/