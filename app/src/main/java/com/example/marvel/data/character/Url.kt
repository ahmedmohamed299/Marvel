package com.example.marvel.data.character


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)