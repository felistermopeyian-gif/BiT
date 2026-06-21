package com.example.studentmanagementapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onBack) { Icon(Icons.Default.Close, null) }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Icon(Icons.Default.LockReset, null, modifier = Modifier.size(100.dp), tint = Color(0xFFD32F2F))
            Spacer(modifier = Modifier.height(24.dp))
            Text("Reset Access Key", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Request an OTA reset from school IT", textAlign = TextAlign.Center, color = Color.Gray, modifier = Modifier.padding(horizontal = 32.dp))
            
            Spacer(modifier = Modifier.height(40.dp))
            
            OutlinedTextField(
                value = email, 
                onValueChange = { email = it }, 
                label = { Text("Official Email") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(12.dp), 
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = androidx.compose.ui.text.input.ImeAction.Done), 
                keyboardActions = KeyboardActions(onDone = { 
                    Toast.makeText(context, "OTA link sent to $email", Toast.LENGTH_LONG).show()
                    onBack()
                }), 
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.Black, unfocusedTextColor = Color.Black)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f).height(56.dp), shape = RoundedCornerShape(12.dp)) {
                    Text("BACK")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { 
                    Toast.makeText(context, "OTA link sent to $email", Toast.LENGTH_LONG).show()
                    onBack()
                }, modifier = Modifier.weight(2f).height(56.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
                    Text("SEND RESET LINK")
                }
            }
        }
    }
}
