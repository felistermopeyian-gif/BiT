package com.example.studentmanagementapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.model.Staff

@Composable
fun SmartStudentCard(
    student: Student, 
    onEdit: () -> Unit, 
    onDelete: () -> Unit, 
    onAttendanceToggle: () -> Unit, 
    onViewHistory: () -> Unit, 
    onViewProfile: () -> Unit
) {
    var showIDCard by remember { mutableStateOf(false) }
    
    if (showIDCard) {
        DigitalIDDialog(name = student.name, id = student.id, sub = student.grade, isStudent = true) { showIDCard = false }
    }

    Card(
        modifier = Modifier.fillMaxWidth().clickable { onViewProfile() },
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp).clip(RoundedCornerShape(20.dp)).background(Color(0xFFE3F2FD)), contentAlignment = Alignment.Center) {
                    Text(student.name.take(1).uppercase(), fontSize = 28.sp, fontWeight = FontWeight.Black, color = Color(0xFF800000))
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(student.name, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color(0xFF1E293B))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(color = Color(0xFF800000).copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp)) {
                            Text(student.grade, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = Color(0xFF800000), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        PerformanceBadge(student.performanceLevel)
                    }
                }
                Checkbox(checked = student.attendanceToday, onCheckedChange = { onAttendanceToggle() }, colors = CheckboxDefaults.colors(checkedColor = Color(0xFF800000)))
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InfoItem(Icons.Default.PhoneInTalk, student.guardianPhone.ifBlank { "No Contact" })
                InfoItem(Icons.Default.QueryStats, "Avg: ${String.format("%.1f", student.averageScore)}%")
            }

            Spacer(modifier = Modifier.height(16.dp))
            
            val feeProgress = if (student.feesTotal > 0) (student.feesPaid / student.feesTotal).toFloat() else 0f
            LinearProgressIndicator(
                progress = { feeProgress }, 
                modifier = Modifier.fillMaxWidth().height(10.dp).clip(CircleShape), 
                color = if (feeProgress >= 1f) Color(0xFF10B981) else Color(0xFFF59E0B), 
                trackColor = Color(0xFFF1F5F9)
            )
            
            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDelete) { 
                    Icon(Icons.Default.DeleteOutline, "Delete", tint = Color(0xFFEF4444)) 
                }
                TextButton(onClick = onViewHistory) {
                    Text("HISTORY", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onEdit, 
                    shape = RoundedCornerShape(12.dp), 
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
                ) {
                    Text("EDIT PROFILE", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun SmartStaffCard(
    staff: Staff, 
    onEdit: () -> Unit, 
    onDelete: () -> Unit, 
    onAttendanceToggle: () -> Unit, 
    onViewHistory: () -> Unit
) {
    var showIDCard by remember { mutableStateOf(false) }
    
    if (showIDCard) {
        DigitalIDDialog(name = staff.name, id = staff.id, sub = staff.role, isStudent = false) { showIDCard = false }
    }

    Card(
        modifier = Modifier.fillMaxWidth().clickable { showIDCard = true },
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp).clip(CircleShape).background(Color(0xFFF5F3FF)), contentAlignment = Alignment.Center) {
                    Text(staff.name.take(1).uppercase(), fontSize = 28.sp, fontWeight = FontWeight.Black, color = Color(0xFF800000))
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(staff.name, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color(0xFF1E293B))
                    Text(staff.role, color = Color(0xFF800000), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Switch(checked = staff.attendanceToday, onCheckedChange = { onAttendanceToggle() }, colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF800000)))
            }
            
            Divider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFF1F5F9))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("EXPECTED PAY", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    Text("₦${staff.netPay.toInt()}", fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color(0xFF800000))
                }
                Surface(color = if(staff.paymentStatus == "Paid") Color(0xFFD1FAE5) else Color(0xFFFEE2E2), shape = RoundedCornerShape(12.dp)) {
                    Text(staff.paymentStatus, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), color = if(staff.paymentStatus == "Paid") Color(0xFF065F46) else Color(0xFF991B1B), fontSize = 12.sp, fontWeight = FontWeight.Black)
                }
            }
            
            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                TextButton(onClick = onDelete) { 
                    Text("REMOVE", color = Color(0xFFEF4444), fontSize = 12.sp, fontWeight = FontWeight.Bold) 
                }
                TextButton(onClick = onViewHistory) {
                    Text("HISTORY", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onEdit, 
                    shape = RoundedCornerShape(12.dp), 
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
                ) {
                    Text("EDIT PROFILE", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
