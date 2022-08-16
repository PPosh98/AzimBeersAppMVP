package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class IngredientsModel(
    @SerializedName("hops")
    val hops: List<HopModel>,
    @SerializedName("malt")
    val malt: List<MaltModel>,
    @SerializedName("yeast")
    val yeast: String
)