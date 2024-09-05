package com.igdel.countin.domain.usecases

import com.igdel.countin.domain.common.Result
import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.repository.RoomRepository

class CreateRoomUseCase(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(total: Int, max: Int, name: String): Result<Room> {
        return roomRepository.createRoom(total, max, name)
    }
}