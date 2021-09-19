package com.praveene.dominosapp.data.model


import com.google.gson.annotations.SerializedName

data class Crust(
    @SerializedName("defaultSize")
    val defaultSize: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("sizes")
    val sizes: List<Size>
)