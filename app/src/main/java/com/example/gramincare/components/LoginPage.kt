@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gramincare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gramincare.R

@Composable
fun LoginPage(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome to", modifier = Modifier.padding(top = 50.dp), fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(10.dp))
        Image(painter = painterResource(id = R.drawable.lifesavers_bust_welcome_icon), contentDescription = null, modifier = Modifier.size(350.dp))
        Spacer(modifier = Modifier.size(10.dp))
        var otpTriggered by remember {
            mutableStateOf(false)
        }
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Mobile number") }
        )
        if(otpTriggered){
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter OTP") }
            )
            Spacer(modifier = Modifier.size(10.dp) )
            TextButton(onClick = { /*TODO*/ }) {
                Text("Resend OTP")
            }
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("Login")
            }
        }
        else{
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { otpTriggered = true }) {
                Text("Send OTP")
            }
        }

    }
}

