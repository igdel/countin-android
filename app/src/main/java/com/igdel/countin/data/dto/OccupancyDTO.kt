package com.igdel.countin.data.dto

import com.google.gson.annotations.SerializedName

data class OccupancyDTO(
    @SerializedName("current") val current: Int?,
    @SerializedName("maximum") val maximum: Int?
)