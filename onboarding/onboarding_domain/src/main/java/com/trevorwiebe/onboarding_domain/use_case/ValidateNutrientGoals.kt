package com.trevorwiebe.onboarding_domain.use_case

import com.trevorwiebe.core.util.UiText
import com.trevorwiebe.core.R

class ValidateNutrientGoals {
    operator fun invoke(
        carbRatioStr: String,
        proteinRatioStr: String,
        fatRatioStr: String
    ): Result {
        val carbRatio = carbRatioStr.toIntOrNull()
        val proteinRatio = proteinRatioStr.toIntOrNull()
        val fatRatio = fatRatioStr.toIntOrNull()
        if(carbRatio == null || proteinRatio == null || fatRatio == null){
            return Result.Error(
                message = UiText.StringResource(R.string.error_invalid_values)
            )
        }
        if(carbRatio+proteinRatio+fatRatio != 100){
            return Result.Error(
                message = UiText.StringResource(R.string.error_not_100_percent)
            )
        }
        return Result.Success(
            carbRatio / 100f,
            proteinRatio / 100f,
            fatRatio / 100f)
    }

    sealed class Result{
        data class Success(
            val carbRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()
        data class Error(val message: UiText): Result()
    }
}