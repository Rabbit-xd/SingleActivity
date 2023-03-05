package com.example.singleactivity.models
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import com.google.gson.annotations.SerializedName

class RedditPost(
    @SerializedName("name")
    val key : String?,
    val title : String?,
    val score: Int?,
    val author: String?,
    @SerializedName("num_comments")
    val commentCount : Int?,
    //var url: String?,
    //var subreddit: String?,
    //var selftext: String?,
    var thumbnail : String?,
    @SerializedName("id")
    var postId : String?,
    //@SerializedName("author_fullname")
    //var authName: String?,
    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String?,
    //var preview: Preview,

)

data class Preview (    var images: List<ImageRes?>        )
/**
data class Resolution (
    var height: Int?,
    var url: String?,
    var width: Int?
)
**/
data class Source(
var height: Int?,
var url: String?,
var width: Int?
)

data class ImageRes (
   // var id: String?,
    var source: Source)