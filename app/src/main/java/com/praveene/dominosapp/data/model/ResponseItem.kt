package com.praveene.dominosapp.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
data class ResponseItem(
    @SerializedName("crusts")
    val crusts: List<Crust>,
    @SerializedName("defaultCrust")
    val defaultCrust: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("isVeg")
    val isVeg: Boolean,
    @SerializedName("name")
    val name: String
)
