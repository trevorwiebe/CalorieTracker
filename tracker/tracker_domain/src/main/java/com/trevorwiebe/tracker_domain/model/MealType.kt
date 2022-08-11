package com.trevorwiebe.tracker_domain.model

import android.util.Log

sealed class MealType(val name: String){
    object Breakfast: MealType("Breakfast")
    object Lunch: MealType("Lunch")
    object Dinner: MealType("Dinner")
    object Snack: MealType("Snacks")

    companion object{
        fun fromString(name: String): MealType{
            return when(name){
                "Breakfast" -> Breakfast
                "Lunch" -> Lunch
                "Dinner" -> Dinner
                "Snacks" -> Snack
                else -> Dinner
            }
        }
    }
}
