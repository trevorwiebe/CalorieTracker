package com.trevorwiebe.onboarding_domain.di

import com.trevorwiebe.onboarding_domain.use_case.ValidateNutrientGoals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {

    @Provides
    @ViewModelScoped
    fun provideValidateNutrientsUseCase(): ValidateNutrientGoals {
        return ValidateNutrientGoals()
    }
}