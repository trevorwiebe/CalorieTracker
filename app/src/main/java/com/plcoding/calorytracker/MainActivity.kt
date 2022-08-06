package com.plcoding.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.calorytracker.navigation.navigate
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import com.trevorwiebe.core.navigation.Route
import com.trevorwiebe.core.util.UiEvent
import com.trevorwiebe.onboarding_presentation.activity.ActivityScreen
import com.trevorwiebe.onboarding_presentation.age.AgeScreen
import com.trevorwiebe.onboarding_presentation.gender.GenderScreen
import com.trevorwiebe.onboarding_presentation.goal.GoalScreen
import com.trevorwiebe.onboarding_presentation.height.HeightScreen
import com.trevorwiebe.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.trevorwiebe.onboarding_presentation.weight.WeightScreen
import com.trevorwiebe.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME
                    ){
                        composable(Route.WELCOME){
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE){
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.GENDER){
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.HEIGHT){
                            HeightScreen(onNavigate = navController::navigate, scaffoldState = scaffoldState)
                        }
                        composable(Route.WEIGHT){
                            WeightScreen(onNavigate = navController::navigate, scaffoldState = scaffoldState)
                        }
                        composable(Route.NUTRIENT_GOAL){
                            NutrientGoalScreen(
                                onNavigate = navController::navigate,
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.ACTIVITY){
                            ActivityScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GOAL){
                            GoalScreen(onNavigate = navController::navigate)
                        }

                        // tracker composables
                        composable(Route.TRACKER_OVERVIEW){

                        }
                        composable(Route.SEARCH){

                        }

                    }
                }
            }
        }
    }
}