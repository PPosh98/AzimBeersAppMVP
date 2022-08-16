package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class BoilVolumeModel(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Int
)