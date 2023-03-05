package com.example.singleactivity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.singleactivity.R
//import com.example.singleactivity.RetrofitHelper
//import com.example.singleactivity.adapters.RedditPageAdapter
import com.example.singleactivity.adapters.RedditPostAdapter
//import com.example.singleactivity.data.dao.RedditApi
//import com.example.singleactivity.databinding.ActivityMainBinding
import com.example.singleactivity.viewmodel.MainViewModel
//import com.example.singleactivity.viewmodel.RedditPostViewModel
import dagger.hilt.android.AndroidEntryPoint
//import android.*
//import androidx.paging.LivePagedListBuilder
import com.example.singleactivity.databinding.ActivityMainBinding
import com.example.singleactivity.models.RedditPost
//import com.example.singleactivity.repositories.PostsDataSource
//import kotlinx.*
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.children_data_modal.*
//import com.example.singleactivity.ui.MainActivity.initializedPagedListBuilder
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.create
import androidx.recyclerview.widget.RecyclerView.LayoutManager as LayoutManager

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),RedditPostAdapter.OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    //lateinit var mainViewModel: MainViewModel
    private val redditPostAdapter = RedditPostAdapter(this)
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mainViewModel = ViewModelProvider.of(this).get(MainViewModel::class.java)
        observeLiveData()
        initializedList()
      // supportFragmentManager.setFragmentResult(key: String? , bundle: Bundle)


    }

    private fun observeLiveData() {
      //  mainViewModel.getPosts().observe(this, Observer {
      //      redditPostAdapter.submitList(it)
      //  })
        lifecycleScope.launch{
            mainViewModel.flow.collectLatest{ pagingData ->
                redditPostAdapter.submitData(pagingData)
            // redditPostAdapter.submitList(pagingData)
            }
        }
    }

    private fun initializedList() {
        val redditRV = binding.redditItemRV
        redditRV.layoutManager = LinearLayoutManager(this)
        redditRV.adapter = redditPostAdapter

  //      redditPostAdapter.withLoadStateHeaderAndFooter(
   //         header = RedditLoadPostAdapter(redditPostAdapter),
     //       footer = RedditLoadPostAdapter(redditPostAdapter)
     //   )
    }

    override fun onItemClick(redditPost: RedditPost) {
        val postId = redditPost.postId
        val detailFragment = DetailFragment()
        val args = Bundle()
        args.putString("key", postId)
        detailFragment.arguments = args

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment,detailFragment)
            addToBackStack("DetailFragment")
            commit()
        }
    }
    /**
    class initializedPagedListBuilder(config: PagedList.Config):


        LivePagedListBuilder<String, RedditPost> {

        val dataSourceFactory = object : DataSource.Factory<String, RedditPost>(){
            override fun create(): DataSource<String, RedditPost> {
                return PostsDataSource()
            }
        }
        return LivePagedListBuilder<String, RedditPost>(dataSourceFactory,config)


    }
**/
    /**
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
    //  mAdapter = RedditPageAdapter() // try version
    adapter = mAdapter
    layoutManager = StaggeredGridLayoutManager(
    1,StaggeredGridLayoutManager.VERTICAL
    )

    /**
    LayoutManager = LinearLayoutManager(
    context, LinearLayoutManager.VERTICAL,false
    )
    **/
    //adapter = mAdapter
    setHasFixedSize(true)
    Log.d("myTag", "Adapter was added to MainActivi")
    }

    }
     **/


}