package com.donmykl.unisearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class University(
    @Expose
    @SerializedName("name")
    val name : String,
    @Expose
    @SerializedName("country")
    val country : String,
    @Expose
    @SerializedName("web_pages")
    val website : List<String>
)