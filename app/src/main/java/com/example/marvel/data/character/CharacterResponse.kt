package com.example.marvel.data.character


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("limit")
    var limit: Int?,
    @SerializedName("offset")
    var offset: Int?,
    @SerializedName("results")
    var characterModels: List<CharacterModel>?,
    @SerializedName("total")
    var total: Int?
)