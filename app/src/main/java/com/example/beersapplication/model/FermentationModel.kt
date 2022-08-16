package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class FermentationModel(
    @SerializedName("temp")
    val temp: TempModel
)