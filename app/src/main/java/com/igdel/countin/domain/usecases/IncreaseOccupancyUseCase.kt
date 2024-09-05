package com.igdel.countin.domain.usecases

import com.igdel.countin.domain.common.Result
import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.repository.RoomRepository

class IncreaseOccupancyUseCase(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(roomId: String): Result<Room> {
        return roomRepository.incrementOccupancy(roomId)
    }
}