package com.example.beersapplication.model


import com.google.gson.annotations.SerializedName

data class BeersItemModel(
    @SerializedName("abv")
    val abv: Double,
    @SerializedName("attenuation_level")
    val attenuationLevel: Double,
    @SerializedName("boil_volume")
    val boilVolume: BoilVolumeModel,
    @SerializedName("brewers_tips")
    val brewersTips: String,
    @SerializedName("contributed_by")
    val contributedBy: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("ebc")
    val ebc: Double,
    @SerializedName("first_brewed")
    val firstBrewed: String,
    @SerializedName("food_pairing")
    val foodPairing: List<String>,
    @SerializedName("ibu")
    val ibu: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("ingredients")
    val ingredients: IngredientsModel,
    @SerializedName("name")
    val name: String,
    @SerializedName("ph")
    val ph: Double,
    @SerializedName("srm")
    val srm: Double,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("target_fg")
    val targetFg: Int,
    @SerializedName("target_og")
    val targetOg: Double,
    @SerializedName("volume")
    val volume: VolumeModel
)