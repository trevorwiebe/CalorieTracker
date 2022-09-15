package com.trevorwiebe.tracker_domain.use_cases

import com.google.common.truth.Truth.assertThat
import com.trevorwiebe.core.domain.model.ActivityLevel
import com.trevorwiebe.core.domain.model.Gender
import com.trevorwiebe.core.domain.model.GoalType
import com.trevorwiebe.core.domain.model.UserInfo
import com.trevorwiebe.core.domain.preferences.Preferences
import com.trevorwiebe.tracker_domain.model.MealType
import com.trevorwiebe.tracker_domain.model.TrackedFood
import com.trevorwiebe.tracker_domain.use_case.CalculateMealNutrients
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.random.Random

class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrients

    @Before
    fun setUp(){
        val preferences = mockk<Preferences>(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 20,
            weight = 80f,
            height = 180,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        calculateMealNutrients = CalculateMealNutrients(preferences)
    }

    @Test
    fun `Calories for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val breakfastCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        assertThat(breakfastCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Carbs for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val breakfastCarbs = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.carbs }

        val expectedCarbs = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.carbs }

        assertThat(breakfastCarbs).isEqualTo(expectedCarbs)
    }

    @Test
    fun `Protein for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val breakfastProtein = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.protein }

        val expectedProtein = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.protein }

        assertThat(breakfastProtein).isEqualTo(expectedProtein)
    }

    @Test
    fun `Fat for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val breakfastFat = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.fat }

        val expectedFat = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.fat }

        assertThat(breakfastFat).isEqualTo(expectedFat)
    }

    @Test
    fun `Calories for lunch properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val lunchCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.calories }

        assertThat(lunchCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Carbs for lunch properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val lunchCarbs = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.carbs }

        val expectedCarbs = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.carbs }

        assertThat(lunchCarbs).isEqualTo(expectedCarbs)
    }

    @Test
    fun `Protein for lunch properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val lunchProtein = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.protein }

        val expectedProtein = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.protein }

        assertThat(lunchProtein).isEqualTo(expectedProtein)
    }

    @Test
    fun `Fat for lunch properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val lunchFat = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }

        val expectedFat = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }

        assertThat(lunchFat).isEqualTo(expectedFat)
    }

    @Test
    fun `Calories for dinner properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val dinnerCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.calories }

        assertThat(dinnerCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Carbs for dinner properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Protein for dinner properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.protein }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.protein }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Fat for dinner properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.fat }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.fat }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Calories for snack properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.calories }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.calories }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Carbs for snack properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.carbs }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.carbs }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Protein for snack properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }

        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    fun `Fat for snack properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                imageUrl = null,
                mealType = MealType.fromString(
                    listOf("Breakfast", "Lunch", "Dinner", "Snack").random()
                ),
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val value = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.fat }

        val expectedValue = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.fat }

        assertThat(value).isEqualTo(expectedValue)
    }
}