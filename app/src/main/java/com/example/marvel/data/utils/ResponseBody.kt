package com.example.marvel.data.utils

import com.google.gson.annotations.SerializedName

data class ResponseBody<T>(
    @SerializedName("code") val responseCode: Int,
    @SerializedName("data") val data: T?,
    @SerializedName("status") val message: String,
)
