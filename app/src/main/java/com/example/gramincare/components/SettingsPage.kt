package com.example.gramincare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gramincare.R

@Composable
fun SettingsPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.avatar_image),
            contentDescription = "User Avatar",
            modifier = Modifier.size(100.dp)
        )

        // Name and Email
        Text(text = "User Name", style = MaterialTheme.typography.headlineSmall, color = Color.Black)
        Text(text = "user.email@example.com", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)

        Spacer(modifier = Modifier.height(55.dp))

        // Settings List
        val settingsItems = listOf("Account", "Appearance", "Location", "Language", "About")
        settingsItems.forEach { item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item, style = MaterialTheme.typography.headlineSmall, color = Color.Black)
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
