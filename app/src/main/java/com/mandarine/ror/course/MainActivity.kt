package com.mandarine.ror.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import com.mandarine.ror.course.data.MockSessions
import com.mandarine.ror.course.navigation.Destinations
import com.mandarine.ror.course.screens.SessionDetailsScreen
import com.mandarine.ror.course.ui.RorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigation()
        }
    }
}

@Composable
private fun MainNavigation() {
    val navController = rememberNavController()
    RorTheme {
        NavHost(
            navController = navController,
            startDestination = Destinations.Main,
        ) {
            composable(Destinations.Main) {
                MainScreen(
                    sessions = MockSessions,
                    favoriteSessions = MockSessions.take(3),
                    onSessionClick = { sessionId ->
                        navController.navigate(
                            "${Destinations.SessionDetails}/$sessionId"
                        )
                    }
                )
            }
            composable(
                "${Destinations.SessionDetails}/{${Destinations.SessionDetailsArgs.SessionId}}",
                arguments = listOf(
                    navArgument(Destinations.SessionDetailsArgs.SessionId) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val sessionId = backStackEntry.arguments?.getString(Destinations.SessionDetailsArgs.SessionId)
                val session = MockSessions.first { it.id == sessionId }
                SessionDetailsScreen(
                    session = session,
                )
            }
        }
    }
}