package com.igdel.countin.domain.repository

import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.common.Result

interface RoomRepository {
    suspend fun getRoomData(roomId: String): Result<Room>
    suspend fun createRoom(total: Int, max: Int, name: String): Result<Room>
    suspend fun incrementOccupancy(roomId: String): Result<Room>
    suspend fun decrementOccupancy(roomId: String): Result<Room>
}