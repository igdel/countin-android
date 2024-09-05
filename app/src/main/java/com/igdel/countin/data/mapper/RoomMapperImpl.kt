package com.igdel.countin.data.mapper

import com.igdel.countin.data.dto.RoomDTO
import com.igdel.countin.domain.model.Occupancy
import com.igdel.countin.domain.model.Room
import com.igdel.countin.domain.common.Result

class RoomMapperImpl : RoomMapper {
    override fun mapFromRoomDTO(dto: RoomDTO): Result<Room> {
        try {
            val spaceId = dto.spaceId ?: return Result.Error(IllegalArgumentException("Space ID is missing"))
            val spaceName = dto.spaceName ?: return Result.Error(IllegalArgumentException("Space name is missing"))
            val occupancyCurrent = dto.occupancy?.current ?: return Result.Error(IllegalArgumentException("Current occupancy is missing"))
            val occupancyMaximum = dto.occupancy?.maximum ?: return Result.Error(IllegalArgumentException("Maximum occupancy is missing"))
            val lastUpdated = dto.lastUpdated ?: return Result.Error(IllegalArgumentException("Last updated time is missing"))

            if (occupancyCurrent > occupancyMaximum) {
                return Result.Error(IllegalArgumentException("Current occupancy cannot exceed the maximum occupancy"))
            }

            return Result.Success(
                Room(
                    spaceId = spaceId,
                    spaceName = spaceName,
                    occupancy = Occupancy(
                        current = occupancyCurrent,
                        maximum = occupancyMaximum
                    ),
                    lastUpdated = lastUpdated
                )
            )
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}
