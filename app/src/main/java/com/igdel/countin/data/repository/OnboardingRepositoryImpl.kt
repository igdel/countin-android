package com.igdel.countin.data.repository

import com.igdel.countin.data.dto.OnboardingScreen
import com.igdel.countin.domain.repository.OnboardingRepository
import com.igdel.countin.domain.common.Result
import com.igdel.countin.domain.exceptions.DomainException

class OnboardingRepositoryImpl(private val onboardingScreens: List<OnboardingScreen>) : OnboardingRepository {
    override fun getOnboardingScreens(): Result<List<OnboardingScreen>> {
        return try {
            if (onboardingScreens.isEmpty()) {
                Result.Error(Exception("No onboarding screens available"))
            } else {
                Result.Success(onboardingScreens)
            }
        } catch (e: Exception) {
            Result.Error(DomainException.UnexpectedException(e))
        }
    }
}