package com.igdel.countin.domain.repository

import com.igdel.countin.data.dto.OnboardingScreen
import com.igdel.countin.domain.common.Result

interface OnboardingRepository {
    fun getOnboardingScreens(): Result<List<OnboardingScreen>>
}