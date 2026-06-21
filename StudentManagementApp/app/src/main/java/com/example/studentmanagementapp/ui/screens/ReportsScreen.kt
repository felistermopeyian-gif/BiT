package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementapp.model.Staff
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.ui.components.FinancialRow
import com.example.studentmanagementapp.ui.components.ReportCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsScreen(students: List<Student>, staffList: List<Staff>, onBack: () -> Unit) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("ANALYTICS & REPORTS", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp).verticalScroll(rememberScrollState())) {
            Text("DATA OVERVIEW", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                ReportCard(Modifier.weight(1f), "Pupils", students.size.toString(), Color(0xFF800000))
                ReportCard(Modifier.weight(1f), "Staff", staffList.size.toString(), Color(0xFF7C3AED))
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            val totalRevenue = students.sumOf { it.feesPaid }
            val totalExpected = students.sumOf { it.feesTotal }
            val debt = totalExpected - totalRevenue
            
            Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)), shape = RoundedCornerShape(24.dp)) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("FINANCIAL SUMMARY", fontWeight = FontWeight.Black, color = Color(0xFF1E293B))
                    Spacer(modifier = Modifier.height(24.dp))
                    FinancialRow("Total Fees Paid", "₦${totalRevenue.toInt()}", Color(0xFF10B981))
                    FinancialRow("Outstanding Debt", "₦${debt.toInt()}", Color(0xFFEF4444))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                    FinancialRow("Gross Revenue", "₦${totalExpected.toInt()}", Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("ACADEMIC PERFORMANCE", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            
            students.groupBy { it.grade }.forEach { (grade, list) ->
                val avg = list.map { it.averageScore }.average()
                Card(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp), shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = Color.White), border = BorderStroke(1.dp, Color(0xFFF1F5F9))) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(grade, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
                        Text("${String.format("%.1f", avg)}%", fontWeight = FontWeight.Black, color = Color(0xFF800000))
                    }
                }
            }
        }
    }
}
