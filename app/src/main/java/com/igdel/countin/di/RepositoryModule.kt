package com.igdel.countin.di

import com.igdel.countin.R
import com.igdel.countin.data.dto.OnboardingScreen
import com.igdel.countin.data.repository.OnboardingRepositoryImpl
import com.igdel.countin.data.repository.RoomRepositoryImpl
import com.igdel.countin.domain.repository.OnboardingRepository
import com.igdel.countin.domain.repository.RoomRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RoomRepository> { RoomRepositoryImpl(apiService = get(), roomMapper = get()) }
    
    single {
        listOf(
            OnboardingScreen(
                R.drawable.onboarding_1,
                R.string.onboarding_onboarding1_title,
                R.string.onboarding_onboarding1_description
            ), OnboardingScreen(
                R.drawable.onboarding_2,
                R.string.onboarding_onboarding2_title,
                R.string.onboarding_onboarding2_description
            ), OnboardingScreen(
                R.drawable.onboarding_3,
                R.string.onboarding_onboarding3_title,
                R.string.onboarding_onboarding3_description
            )
        )
    }
    single<OnboardingRepository> { OnboardingRepositoryImpl(onboardingScreens = get()) }
}