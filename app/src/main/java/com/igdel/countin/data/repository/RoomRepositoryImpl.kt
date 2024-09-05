package com.igdel.countin.data.repository

import com.igdel.countin.data.api.ApiService
import com.igdel.countin.data.exceptions.RoomResponseException
import com.igdel.countin.data.mapper.RoomMapper
import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.common.Result
import com.igdel.countin.domain.exceptions.DomainException
import com.igdel.countin.domain.repository.RoomRepository
import com.igdel.countin.domain.exceptions.DomainException.UnexpectedException

class RoomRepositoryImpl(
    private val apiService: ApiService,
    private val roomMapper: RoomMapper
) : RoomRepository {

    override suspend fun getRoomData(roomId: String): Result<Room> {
        return try {
            val response = apiService.getRoomResponse(roomId)
            if (!response.isSuccessful) Result.Error(DomainException.NetworkException())
            val roomResponseDTO = response.body() ?: return Result.Error(RoomResponseException("Error getting room data"))
            roomMapper.mapFromRoomDTO(roomResponseDTO)
        } catch (e: Exception) {
            Result.Error(UnexpectedException(e))
        }
    }

    override suspend fun createRoom(total: Int, max: Int, name: String): Result<Room> {
        return try {
            val response = apiService.createRoom(total, max, name)
            if (!response.isSuccessful) Result.Error(DomainException.NetworkException())
            val roomResponseDTO = response.body() ?: return Result.Error(RoomResponseException("Error creating room"))
            roomMapper.mapFromRoomDTO(roomResponseDTO)
        } catch (e: Exception) {
            Result.Error(UnexpectedException(e))
        }
    }

    override suspend fun incrementOccupancy(roomId: String): Result<Room> {
        return try {
            val response = apiService.incrementOccupancy(roomId)
            if (!response.isSuccessful) Result.Error(DomainException.NetworkException())
            val roomResponseDTO = response.body() ?: return Result.Error(RoomResponseException("Error incrementing occupancy"))
            roomMapper.mapFromRoomDTO(roomResponseDTO)
        } catch (e: Exception) {
            Result.Error(UnexpectedException(e))
        }
    }

    override suspend fun decrementOccupancy(roomId: String): Result<Room> {
        return try {
            val response = apiService.decrementOccupancy(roomId)
            if (!response.isSuccessful) Result.Error(DomainException.NetworkException())
            val roomResponseDTO = response.body() ?: return Result.Error(RoomResponseException("Error decrementing occupancy"))
            roomMapper.mapFromRoomDTO(roomResponseDTO)
        } catch (e: Exception) {
            Result.Error(UnexpectedException(e))
        }
    }
}