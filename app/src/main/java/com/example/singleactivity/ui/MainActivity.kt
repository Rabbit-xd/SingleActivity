package com.example.singleactivity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.singleactivity.R
//import com.example.singleactivity.RetrofitHelper
import com.example.singleactivity.adapters.RedditPageAdapter
import com.example.singleactivity.data.dao.RedditApi
import com.example.singleactivity.databinding.ActivityMainBinding
import com.example.singleactivity.viewmodel.RedditPostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create
import androidx.recyclerview.widget.RecyclerView.LayoutManager as LayoutManager

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter: RedditPageAdapter
    private val viewModel: RedditPostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        loadingData()

/**
        val redditApi = RetrofitHelper.getInstance().create(RedditApi::class.java)
        GlobalScope.launch {
            val result = redditApi.getBestPost()
            if (result != null) Log.d("myTag", result.toString())
        }   **/
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect{ pagingData ->
                mAdapter.submitData(pagingData)

            }
        }
    }

    private fun setupRV() {
        mAdapter = RedditPageAdapter()
        binding.redditItemRV.apply {

            layoutManager = StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.VERTICAL
            )

            /**
            LayoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL,false
            )
            **/
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}