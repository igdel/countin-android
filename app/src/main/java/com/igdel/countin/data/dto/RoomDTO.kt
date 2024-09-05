package com.igdel.countin.data.dto

import com.google.gson.annotations.SerializedName

data class RoomDTO(
    @SerializedName("space_id") val spaceId: String?,
    @SerializedName("space_name") val spaceName: String?,
    @SerializedName("occupancy") val occupancy: OccupancyDTO?,
    @SerializedName("created") val created: String?,
    @SerializedName("last_updated") val lastUpdated: String?
)