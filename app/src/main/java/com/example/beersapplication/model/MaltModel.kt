package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class MaltModel(
    @SerializedName("amount")
    val amount: AmountModel,
    @SerializedName("name")
    val name: String
)