package com.igdel.countin.data.mapper

import com.igdel.countin.data.dto.RoomDTO
import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.common.Result

interface RoomMapper {
    fun mapFromRoomDTO(dto: RoomDTO): Result<Room>
}