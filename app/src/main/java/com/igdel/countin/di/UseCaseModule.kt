package com.igdel.countin.di
import com.igdel.countin.domain.usecases.GetRoomDataUseCase
import com.igdel.countin.domain.usecases.CreateRoomUseCase
import com.igdel.countin.domain.usecases.DecreaseOccupancyUseCase
import com.igdel.countin.domain.usecases.GetOnboardingScreensUseCase
import com.igdel.countin.domain.usecases.IncreaseOccupancyUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetRoomDataUseCase(roomRepository = get()) }
    single { CreateRoomUseCase(roomRepository = get()) }
    single { IncreaseOccupancyUseCase(roomRepository = get()) }
    single { DecreaseOccupancyUseCase(roomRepository = get()) }
    single { GetOnboardingScreensUseCase(repository = get()) }
}