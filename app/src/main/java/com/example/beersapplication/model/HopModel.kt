package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class HopModel(
    @SerializedName("add")
    val add: String,
    @SerializedName("amount")
    val amount: AmountModel,
    @SerializedName("attribute")
    val attribute: String,
    @SerializedName("name")
    val name: String
)