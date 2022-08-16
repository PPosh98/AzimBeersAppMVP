package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class MethodModel(
    @SerializedName("fermentation")
    val fermentation: FermentationModel,
    @SerializedName("twist")
    val twist: String
)