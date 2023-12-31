package com.example.gramincare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gramincare.R
import kotlinx.coroutines.delay

@Composable
fun WelcomePage(
    navController: NavController,
    isLoggedIn: Boolean,
){

    LaunchedEffect(Unit) {
        delay(1000L)
        if (isLoggedIn) navController.navigate("homePage",)
        else
        navController.navigate("loginPage",)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome to", modifier = Modifier.padding(top = 100.dp), fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(5.dp))
        Text("GraminCare", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(30.dp))
        Image(painter = painterResource(id = R.drawable.lifesavers_bust_welcome_icon), contentDescription = null, modifier = Modifier.size(450.dp))
        Spacer(modifier = Modifier.size(10.dp))
    }

}





//                    var showWelcome by remember { mutableStateOf(true) }
//
//                    LaunchedEffect(Unit) {
//                        delay(1000L)
//                        showWelcome = false
//                    }
//
//                    if (showWelcome) {
//                        WelcomePage()
//                    } else {
//                        LoginPage()
//                    }
