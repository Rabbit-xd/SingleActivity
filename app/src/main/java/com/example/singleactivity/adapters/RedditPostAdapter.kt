package com.example.singleactivity.adapters

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.singleactivity.R
import com.example.singleactivity.databinding.ChildrenDataModalBinding
import com.example.singleactivity.databinding.FragmentDetailBinding
import com.example.singleactivity.models.PostContainer
import com.example.singleactivity.models.RedditPost
import com.example.singleactivity.ui.DetailFragment
import com.example.singleactivity.utils.DiffUtilCallBack
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlin.coroutines.coroutineContext


class RedditPostAdapter(private val listener: OnItemClickListener):
    PagingDataAdapter<RedditPost,RedditPostAdapter.MyViewHolders>(
    DiffUtilCallBack()) {

    //lateinit var _binding: FragmentDetailBinding
    private var itemsP = listOf<String>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.children_data_modal,parent,false )

        return MyViewHolders(view)
    }

    override fun onBindViewHolder(holder: MyViewHolders, position: Int) {
        getItem(position)?.let {holder.bindPost(it)}
        //getItem(position)?.let { holder.bindFrag(it) }

    }

    interface OnItemClickListener{
        fun onItemClick(redditPost: RedditPost)
    }

    private var onItemClickListener: ((RedditPost) ->Unit)? = null

    fun setOnItemClickListener(listener: (RedditPost) ->Unit){
        onItemClickListener = listener
    }

    inner class MyViewHolders(itemView: View):RecyclerView.ViewHolder(itemView) {
        val binding = ChildrenDataModalBinding.bind(itemView)
        private val scoreText = binding.tvScore
        private val commentText= binding.tvComments
        private val titleText = binding.tvTitle
        private val subText = binding.tvSubreddit
        private val authorText = binding.tvAuthor
        private var thumbnailView = binding.imageView
        //private var thumbFrag = _binding.imgFrag
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                //val _binding = FragmentDetailBinding
                if (position != RecyclerView.NO_POSITION){
                    val item = getItem(adapterPosition)
                    if (item != null){
                        listener.onItemClick(item)
                        Log.d("MyTagg", " Item : $item")
                        Log.d("MyTagg"," Position : $position ")
                      //  var titleF = _binding.tvTitleFrag.text
                      //  titleF = binding.tvTitle.text
                      //  _binding.tvAuthorFrag.text = binding.tvAuthor.text
                      //  _binding.tvSubredditF.text = binding.tvSubreddit.text
//
                      //  Log.d("MyRagg", "Title : $titleF")



                    }
                }


            }

        }

        fun bindPost(redditPost: RedditPost) {
            with(redditPost) {
                scoreText.text = score.toString()
                commentText.text = commentCount.toString()
                titleText.text= title
                subText.text = subredditNamePrefixed
                authorText.text = author
                //nameText.text = key

                val imageURL = redditPost.thumbnail
                if (imageURL != "self") {
                    if (redditPost.thumbnail?.startsWith("http") == true) {
                        thumbnailView.visibility = View.VISIBLE
                        Glide.with(thumbnailView)
                            .load(imageURL)
                            .error(R.drawable.baseline_clear_24)
                            .into(thumbnailView)

                    } else {
                        Glide.with(thumbnailView)
                            .load(imageURL)
                            .error(R.drawable.baseline_clear_24)
                            .into(thumbnailView)
                    }
                }else {
                    thumbnailView.visibility = GONE
                }
            }

        }

        fun bindFrag( detailFragment: RedditPost){
             //val _binding = FragmentDetailBinding.bind(itemView)
            //var thumbeFrag = _binding.imgFrag
            //with(detailFragment){

                //_binding.tvTitleFrag.text = titleText.text
               // thumbeFrag = thumbnailView
            //}
        }
    }


}