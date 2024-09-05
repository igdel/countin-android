package com.igdel.countin.di

import com.igdel.countin.data.mapper.RoomMapper
import com.igdel.countin.data.mapper.RoomMapperImpl
import com.igdel.countin.domain.model.Room
import org.koin.dsl.module

val mapperModule = module {
    single<RoomMapper> { RoomMapperImpl() }
}