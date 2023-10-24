@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gramincare.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController,
    logout: () -> Unit
) {
    val locNavController = rememberNavController()
    var selectedItem by remember { mutableIntStateOf(0) }
    val navTitleList = listOf(
        NavigationBarTitle("Dashboard", Icons.Filled.List),
        NavigationBarTitle("Location", Icons.Filled.LocationOn),
        NavigationBarTitle("History", Icons.Default.Info),
        NavigationBarTitle("Settings", Icons.Filled.Settings),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = navTitleList[selectedItem].title, modifier = Modifier.padding(16.dp)) },
                actions = {
                    IconButton(onClick = {
                        logout()
                        navController.navigate("loginPage")
                    }) {
                        Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                navTitleList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon( imageVector = item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            locNavController.navigate(item.title)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = locNavController,
            startDestination = navTitleList[0].title
        ) {
            composable("Dashboard") {
                EmergencyButton(navController = navController)
            }
            composable("Location") {
                BingMap()
            }
            composable("History") {
                SettingsPage()
            }
            composable("Settings") {
                SettingsPage()
            }
        }
    }
}

data class NavigationBarTitle(
    val title: String,
    val icon: ImageVector
)

@Composable
fun EmergencyButton(
    navController: NavController
) {
    Row(){
        Text(
            text = "Emergency Button",
            modifier = Modifier.padding(16.dp)
        )
        IconButton(onClick = {
            navController.navigate("emergencyCallPage")
        }) {
            Icon(imageVector = Icons.Filled.Call, contentDescription = "Emergency")
        }
    }

}