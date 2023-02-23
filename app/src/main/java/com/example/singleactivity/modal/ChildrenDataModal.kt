package com.example.singleactivity.modal

import PreviewX
import com.google.gson.annotations.SerializedName
import java.util.*

data class ChildrenDataModal(
    @SerializedName("approved_at_utc")
    var approvedAtUtc: String?,
    var subreddit: String?,
    var selftext: String?,
    @SerializedName("author_fullname")
    var authName: String?,
    //var saved: Boolean?,
    @SerializedName("mod_reason_title")
    var modReasonTitle: String?,
    var gilded: Int?,
    var clicked: Boolean,
    var title: String?,
    //@SerializedName("link_flair_richtext")
    //var linkFlairRichtext: Arrays,
    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String?,
    //var hidden: Boolean?,
    var pwls: Int?,
    @SerializedName("link_flair_css_class")
    var linkFlairCssClass: String?,
    var downs: Int?,
    var ups: Int?,
    var score: Int?,
    var num_comments: Int?,
    var url: String?,
    var name: String?,
    var domain: String?,
    var author: String?,
    var id: String?,
    var subreddit_id: String?,
    var permalink: String?,
    var media: MediaModal?,
    var is_video: Boolean?,
    var thumbnail_height: Int?,
    var thumbnail_width: Int?,
    var thumbnail: String?,
    var url_overridden_by_dest: String?,
    var preview: PreviewX?,
    )
