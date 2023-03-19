package com.example.marvel.data.character


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CharacterModel(
    @SerializedName("comics")
    var comics: @RawValue Comics? =null,
    @SerializedName("description")
    var description: String?=null,
    @SerializedName("events")
    var events: @RawValue Comics?=null,
    @SerializedName("id")
    var id: Int?=null,
    @SerializedName("modified")
    var modified: String?=null,
    @SerializedName("name")
    var name: String?=null,
    @SerializedName("resourceURI")
    var resourceURI: String?=null,
    @SerializedName("series")
    var series: @RawValue Comics?=null,
    @SerializedName("stories")
    var stories: @RawValue Comics?=null,
    @SerializedName("thumbnail")
    var thumbnail: @RawValue Thumbnail?=null,
    @SerializedName("urls")
    var urls: @RawValue List<Url>?=null
) : Parcelable