package com.example.singleactivity.models
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
class RedditListing(
    val children : List<PostContainer>,
    val after: String?,
    val before: String?
)