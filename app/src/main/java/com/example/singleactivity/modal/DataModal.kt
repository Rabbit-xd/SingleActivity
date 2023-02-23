package com.example.singleactivity.modal

import com.google.gson.annotations.SerializedName

data class DataModal(
    var after: String,
    var dist: Int,
    var modhash : String,
    @SerializedName(value = "geo_filter")
    var geoFilter: Boolean,
    var children: List<ChildrenModal?>

)
