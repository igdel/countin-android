package com.igdel.countin.domain.usecases

import com.igdel.countin.data.dto.OnboardingScreen
import com.igdel.countin.domain.common.Result
import com.igdel.countin.domain.repository.OnboardingRepository

class GetOnboardingScreensUseCase(private val repository: OnboardingRepository) {
    operator fun invoke(): Result<List<OnboardingScreen>> {
        return repository.getOnboardingScreens()
    }
}