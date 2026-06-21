package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementapp.model.AttendanceRecord
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.ui.components.EmptyStateView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(student: Student, history: List<AttendanceRecord>, onBack: () -> Unit) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("ATTENDANCE HISTORY", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp)) {
            Text(student.name.uppercase(), fontWeight = FontWeight.ExtraBold, fontSize = 24.sp, color = Color(0xFF800000))
            Text("Reg ID: ${student.id}", color = Color.Gray, fontSize = 14.sp)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            if (history.isEmpty()) {
                EmptyStateView("No records found for this student")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(history) { record ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = if(record.isPresent) Color(0xFFD1FAE5) else Color(0xFFFEE2E2)),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if(record.isPresent) Icons.Default.CheckCircle else Icons.Default.Cancel,
                                    contentDescription = null,
                                    tint = if(record.isPresent) Color(0xFF059669) else Color(0xFFDC2626)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(record.formattedDate, fontWeight = FontWeight.Bold, color = if(record.isPresent) Color(0xFF065F46) else Color(0xFF991B1B))
                                Spacer(modifier = Modifier.weight(1f))
                                Text(if(record.isPresent) "PRESENT" else "ABSENT", fontSize = 10.sp, fontWeight = FontWeight.Black)
                            }
                        }
                    }
                }
            }
        }
    }
}
