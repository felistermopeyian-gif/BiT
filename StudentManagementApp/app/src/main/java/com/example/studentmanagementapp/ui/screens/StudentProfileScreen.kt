package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.ui.components.ProfileInfoRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentProfileScreen(student: Student, onEdit: (Student) -> Unit, onDelete: (String) -> Unit, onBack: () -> Unit) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("STUDENT PROFILE", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(120.dp).clip(CircleShape).background(Color(0xFFFFF1F1)), contentAlignment = Alignment.Center) {
                Text(student.name.take(1).uppercase(), fontSize = 48.sp, fontWeight = FontWeight.Black, color = Color(0xFF800000))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(student.name.uppercase(), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF800000))
            Text(student.grade, color = Color.Gray, fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)), shape = RoundedCornerShape(24.dp)) {
                Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    ProfileInfoRow("Admission No", student.id)
                    ProfileInfoRow("Course/Grade", student.grade)
                    ProfileInfoRow("Guardian", student.guardianName)
                    ProfileInfoRow("Phone", student.guardianPhone)
                    ProfileInfoRow("Status", student.status)
                    Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.LightGray.copy(alpha = 0.5f))
                    ProfileInfoRow("Average Score", String.format("%.2f", student.averageScore))
                    ProfileInfoRow("Performance", student.performanceLevel)
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(
                    onClick = { onDelete(student.id) },
                    modifier = Modifier.weight(1f).height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Icon(Icons.Default.Delete, null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("DELETE", fontWeight = FontWeight.Bold)
                }
                Button(
                    onClick = { onEdit(student) },
                    modifier = Modifier.weight(1f).height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
                ) {
                    Icon(Icons.Default.Edit, null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("EDIT", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
