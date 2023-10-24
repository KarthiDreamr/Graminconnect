package com.example.gramincare.navigation_handler

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gramincare.R
import com.example.gramincare.components.BingMap
import com.example.gramincare.components.EmergencyCall
import com.example.gramincare.components.HomePage
import com.example.gramincare.components.LoginPage
import com.example.gramincare.components.OnBoardPage
import com.example.gramincare.components.OnboardPage
import com.example.gramincare.components.SettingsPage
import com.example.gramincare.components.WelcomePage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainNavigator() {
    var isOnboarded by remember { mutableStateOf(false) }

    fun finishOnboarding() {
        isOnboarded = true
    }

    var isLoggedIn by remember { mutableStateOf(false) }

    fun Login() {
        isLoggedIn = true
    }

    fun Logout() {
        isLoggedIn = false
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (!isOnboarded) "onboardingPage" else "welcomePage"
    ) {
        composable("onboardingPage") {
            val onboardPageDetails = listOf(
                OnboardPage(
                    R.drawable.lifesavers_handonboarding_1,
                    "Registration of ASHA workers",
                    "The digitalization of Asha workers in our app streamlines their workflow, allowing easy access to patient data, enabling real-time communication with healthcare professionals."
                ),
                OnboardPage(
                    R.drawable.lifesavers_caretakingonboarding_2,
                    "Delivery of medicines",
                    "Our system empowers Asha workers to deliver medicines efficiently, ensuring timely access to essential medications for patients in rural areas. This initiative facilitates better health outcomes and increased healthcare accessibility"
                ),
                OnboardPage(
                    R.drawable.lifesavers_new_patientonboarding_3,
                    "First aid services",
                    "Following audio calls during emergencies, Asha workers provide essential first aid services. Their prompt response and guidance play a vital role in stabilizing the situation, offering immediate care until professional medical assistance can be accessed."
                )
            )

            OnBoardPage(
                onboardPageDetails = onboardPageDetails,
                finishOnboarding = { finishOnboarding() },
                navController = navController
            )

        }
        composable("welcomePage") {
            WelcomePage(navController = navController, isLoggedIn = isLoggedIn)
        }
        composable("loginPage") {
            LoginPage(navController = navController, login = { Login() })
        }
        composable("homePage") {
            HomePage(navController = navController, logout = { Logout() })
        }
        composable("locationPage") {
            BingMap()
        }
        composable("settingsPage") {
            SettingsPage()
        }
        composable("emergencyCallPage") {
            EmergencyCall(navController = navController)
        }

    }
}