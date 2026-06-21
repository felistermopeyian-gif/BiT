package com.example.studentmanagementapp.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.*
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.studentmanagementapp.data.remote.AcademyNews
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.model.Staff
import kotlinx.coroutines.delay

@Composable
fun DrawerItem(icon: ImageVector, label: String, color: Color = Color.Black, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = color, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Text(label, color = color, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun NoticeBoard() {
    val messages = listOf(
        "📢 Mid-term assessment starts tomorrow.",
        "🗓️ Library clearance for Nursery students ongoing.",
        "💡 School bus maintenance scheduled for Saturday.",
        "🌟 Congratulations to Primary 5 for best attendance!"
    )
    var currentIndex by remember { mutableIntStateOf(0) }
    
    LaunchedEffect(Unit) {
        while(true) {
            delay(4000)
            currentIndex = (currentIndex + 1) % messages.size
        }
    }

    Box(modifier = Modifier.fillMaxWidth().background(Color.White.copy(alpha = 0.1f)).padding(8.dp), contentAlignment = Alignment.Center) {
        AnimatedContent(targetState = messages[currentIndex], transitionSpec = { fadeIn() togetherWith fadeOut() }, label = "Notice") { text ->
            Text(text, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1)
        }
    }
}

@Composable
fun SummaryChip(label: String, value: String, icon: ImageVector) {
    Surface(color = Color.White.copy(alpha = 0.15f), shape = RoundedCornerShape(16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, modifier = Modifier.size(20.dp), tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(value, color = Color.White, fontWeight = FontWeight.Black, fontSize = 16.sp)
                Text(label, color = Color.White.copy(alpha = 0.7f), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun NewsCard(news: AcademyNews) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(news.title.uppercase(), fontWeight = FontWeight.Bold, color = Color(0xFF800000))
            Spacer(modifier = Modifier.height(8.dp))
            Text(news.content, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun DigitalIDDialog(name: String, id: String, sub: String, isStudent: Boolean, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth().height(450.dp), shape = RoundedCornerShape(40.dp)) {
            Box(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(if(isStudent) Color(0xFF800000) else Color(0xFF7C3AED), Color.Black))))
                
                Column(modifier = Modifier.fillMaxSize().padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("OSUYAI ACADEMY", color = Color.White, fontWeight = FontWeight.Black, fontSize = 18.sp, letterSpacing = 4.sp)
                    Text("OFFICIAL DIGITAL ID", color = Color.White.copy(alpha = 0.6f), fontSize = 10.sp)
                    
                    Spacer(modifier = Modifier.height(40.dp))
                    
                    Surface(modifier = Modifier.size(140.dp), shape = CircleShape, color = Color.White, border = BorderStroke(4.dp, Color.White.copy(alpha = 0.2f))) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(name.take(1), fontSize = 72.sp, fontWeight = FontWeight.Black, color = if(isStudent) Color(0xFF800000) else Color(0xFF7C3AED))
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(name.uppercase(), color = Color.White, fontWeight = FontWeight.Black, fontSize = 24.sp, textAlign = TextAlign.Center)
                    Text(sub, color = if(isStudent) Color(0xFF60A5FA) else Color(0xFFC084FC), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp)).padding(16.dp), horizontalArrangement = Arrangement.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("IDENTITY CODE", color = Color.White.copy(alpha = 0.5f), fontSize = 10.sp)
                            Text(id, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
                    }
                    
                    Spacer(modifier = Modifier.weight(1f))
                    Text("SCAN FOR VERIFICATION", color = Color.White.copy(alpha = 0.3f), fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun PerformanceBadge(level: String) {
    val color = when(level) {
        "Excellent" -> Color(0xFF10B981)
        "Good" -> Color(0xFF3B82F6)
        "Fair" -> Color(0xFFF59E0B)
        else -> Color(0xFFEF4444)
    }
    Surface(color = color.copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp)) {
        Text(level, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = color, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun InfoItem(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, modifier = Modifier.size(14.dp), tint = Color.Gray)
        Spacer(modifier = Modifier.width(6.dp))
        Text(text, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun EmptyStateView(message: String) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(Icons.Default.CloudQueue, null, modifier = Modifier.size(100.dp), tint = Color.LightGray)
        Spacer(modifier = Modifier.height(16.dp))
        Text(message, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
    }
}

@Composable
fun FormSectionTitle(title: String) {
    Text(title, modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp), fontSize = 12.sp, fontWeight = FontWeight.Black, color = Color(0xFF800000), letterSpacing = 2.sp)
}

@Composable
fun ReportCard(modifier: Modifier, title: String, value: String, color: Color) {
    Card(modifier = modifier, shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = color)
            Text(value, fontSize = 24.sp, fontWeight = FontWeight.Black, color = color)
        }
    }
}

@Composable
fun FinancialRow(label: String, value: String, color: Color) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = Color.Gray, fontSize = 14.sp)
        Text(value, color = color, fontWeight = FontWeight.Black, fontSize = 14.sp)
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = Color.Gray, fontSize = 14.sp)
        Text(value, fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 14.sp)
    }
}
