package com.example.gramincare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gramincare.R

@Composable
fun EmergencyCall(navController: NavController) {
    var isOngoing by remember { androidx.compose.runtime.mutableStateOf(false) }

    fun callAction() {
        isOngoing = !isOngoing
    }

    if (isOngoing) {
        EmergencyCallOngoing(
            navController = navController,
            cutCall = {
                callAction()
            }
        )
    } else {
        EmergencyCallIncoming(
            navController = navController,
            attendCall = {
                callAction()
            }
        )
    }
}

@Composable
fun EmergencyCallIncoming(
    navController: NavController,
    attendCall: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            painter = painterResource(id = R.drawable.emergency_ambulance_light),
            contentDescription = null,
            Modifier.scale(3f)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text("Emergency Call", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            IconButton(
                onClick = { attendCall() },
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.accept_call),
                        contentDescription = null,
                        Modifier.scale(3f)
                    )
                }
            )

            Spacer(modifier = Modifier.size(10.dp)  )

            IconButton(
                onClick = {
                    navController.navigate("homePage")
                },
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.reject_call),
                        contentDescription = null,
                        Modifier.scale(3f)
                    )
                }
            )

        }
    }
}

@Composable
fun EmergencyCallOngoing(
    navController: NavController,
    cutCall: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            painter = painterResource(id = R.drawable.emergency_ambulance_light),
            contentDescription = null,
            Modifier.scale(3f)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text("Emergency Call", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(10.dp))
        Text("00:30", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(
            onClick = { cutCall() },
            content = {
                Image(painter = painterResource(id = R.drawable.reject_call), contentDescription = null,
                    Modifier.scale(3f))
            }
        )

    }
}