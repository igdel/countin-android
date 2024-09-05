package com.igdel.countin.domain.model

data class Room(
    val spaceId: String,
    val spaceName: String,
    val occupancy: Occupancy,
    val lastUpdated: String
)