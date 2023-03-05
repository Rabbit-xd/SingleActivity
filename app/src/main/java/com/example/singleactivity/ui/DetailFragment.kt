package com.example.singleactivity.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.singleactivity.R
import com.example.singleactivity.adapters.RedditPostAdapter
import com.example.singleactivity.adapters.RedditPostAdapter.MyViewHolders
import com.example.singleactivity.databinding.FragmentDetailBinding
import com.example.singleactivity.models.RedditPost
import com.example.singleactivity.net.ApiEndPoints.BASE_URL_OF
import com.example.singleactivity.net.ApiService
import com.example.singleactivity.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.Paths.get

class DetailFragment : Fragment(R.layout.fragment_detail){//,RedditPostAdapter.OnItemClickListener{
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyViewHolders>? = null
    lateinit var binding: FragmentDetailBinding
    private var postId: String? = null
    private var redditPost : RedditPost? = null
  //  private var postId:
    //private val redditPostAdapter = RedditPostAdapter(this)
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            postId = it.getString("postId")
            Log.d("myTag" , "${postId}")
            //foundPostId()
        }
       // foundPostId()

    }

    val retrofit  = Retrofit.Builder()
        .baseUrl(BASE_URL_OF)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(ApiService::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val postIds = arguments?.getString("postId")
        Log.d("myTag" , "$postIds")
        binding.tvSubredditF.text = redditPost?.subredditNamePrefixed
        fun bindPostToFragment(redditPost: RedditPost){
            val subFr = binding.tvSubredditF
            subFr.text = redditPost.subredditNamePrefixed
        }
        //foundPostId()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //foundPostId()
        binding.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
            tvAuthorFrag.text = redditPost?.author
            tvSubredditF.text = redditPost?.subredditNamePrefixed
            tvTitleFrag.text = redditPost?.title

        }
        suspend fun toFrag() {
            mainViewModel.flow.collectLatest { paggingData ->
                binding.tvTitleFrag.text = redditPost?.subredditNamePrefixed
            }
        }

        //observeLiveData()
        fun bindPostToFragment1(redditPost: RedditPost){
            val subFr = binding.tvSubredditF
            subFr.text = redditPost.subredditNamePrefixed
        }
    }
   // fun foundPostId(){
   //     lifecycleScope.launch{
   //         val response = api.getPost(postId)
   //         if (response.isSuccessful){
   //             val post =  response.body()?.data?.children?.apply {
   //                 binding.tvTitleFrag.text = redditPost?.title
//
   //                 binding.tvSubredditF.text = redditPost?.subredditNamePrefixed
   //             }
   //             Log.d("myTagPost","Post: $post")
   //         }
   //     }
   // }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

  // private fun observeLiveData() {
  //     lifecycleScope.launch {
  //         mainViewModel.flow.collectLatest { pagingData ->
  //             redditPostAdapter.submitData(pagingData)

  //         }
  //     }


  // }

   // override fun onItemClick(redditPost: RedditPost) {
   //     TODO("Not yet implemented")
   // }
   companion object{
       @JvmStatic
       fun newInstance() = DetailFragment()
   }
}