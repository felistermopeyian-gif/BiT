package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.studentmanagementapp.model.Staff
import com.example.studentmanagementapp.ui.components.FormSectionTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffFormScreen(staff: Staff?, onSave: (Staff) -> Unit, onBack: () -> Unit) {
    var id by remember { mutableStateOf(staff?.id ?: "") }
    var name by remember { mutableStateOf(staff?.name ?: "") }
    var role by remember { mutableStateOf(staff?.role ?: "Teacher") }
    var salary by remember { mutableStateOf(staff?.salary?.toString() ?: "0.0") }
    var bankName by remember { mutableStateOf(staff?.bankName ?: "") }
    var accountNumber by remember { mutableStateOf(staff?.accountNumber ?: "") }
    val focusManager = LocalFocusManager.current

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("STAFF IDENTITY FORM", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp).verticalScroll(rememberScrollState())) {
            FormSectionTitle("IDENTITY")
            OutlinedTextField(
                value = id, 
                onValueChange = { id = it }, 
                label = { Text("Staff ID") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp), 
                enabled = staff == null,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = name, 
                onValueChange = { name = it }, 
                label = { Text("Full Name") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            FormSectionTitle("PAYROLL")
            OutlinedTextField(
                value = salary, 
                onValueChange = { salary = it }, 
                label = { Text("Base Salary (₦)") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = bankName, 
                onValueChange = { bankName = it }, 
                label = { Text("Bank Name") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = accountNumber, 
                onValueChange = { accountNumber = it }, 
                label = { Text("Account Number") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { if (id.isNotBlank() && name.isNotBlank()) onSave(Staff(id = id, name = name, role = role, salary = salary.toDoubleOrNull() ?: 0.0, bankName = bankName, accountNumber = accountNumber)) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(48.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f).height(64.dp), shape = RoundedCornerShape(20.dp)) {
                    Text("BACK", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { 
                        if (id.isNotBlank() && name.isNotBlank()) onSave(Staff(id = id, name = name, role = role, salary = salary.toDoubleOrNull() ?: 0.0, bankName = bankName, accountNumber = accountNumber)) 
                    }, 
                    modifier = Modifier.weight(1.5f).height(64.dp), 
                    shape = RoundedCornerShape(20.dp), 
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000), disabledContainerColor = Color.LightGray),
                    enabled = id.isNotBlank() && name.isNotBlank()
                ) {
                    Text("COMMIT & NEXT", fontWeight = FontWeight.Black)
                }
            }
        }
    }
}
