package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(onBack: () -> Unit) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("ABOUT APP", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Icon(Icons.Default.AutoStories, null, modifier = Modifier.size(80.dp), tint = Color(0xFF800000))
            Spacer(modifier = Modifier.height(24.dp))
            Text("OSUYAI ACADEMY", fontSize = 24.sp, fontWeight = FontWeight.Black)
            Text("Version 1.0.0", color = Color.Gray)
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "A complete student management solution featuring offline database synchronization, attendance tracking, and real-time news updates.",
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text("Developed by Felister", fontWeight = FontWeight.Bold, color = Color(0xFF800000))
        }
    }
}
