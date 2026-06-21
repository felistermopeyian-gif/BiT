package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.model.SubjectScore
import com.example.studentmanagementapp.ui.components.FormSectionTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentFormScreen(student: Student?, onSave: (Student) -> Unit, onBack: () -> Unit) {
    var id by remember { mutableStateOf(student?.id ?: "") }
    var name by remember { mutableStateOf(student?.name ?: "") }
    var grade by remember { mutableStateOf(student?.grade ?: "BIT") }
    var year by remember { mutableIntStateOf(student?.year ?: 1) }
    var gender by remember { mutableStateOf(student?.gender ?: "Male") }
    var guardianName by remember { mutableStateOf(student?.guardianName ?: "") }
    var guardianPhone by remember { mutableStateOf(student?.guardianPhone ?: "") }
    var feesPaid by remember { mutableStateOf(student?.feesPaid?.toString() ?: "0.0") }
    var feesTotal by remember { mutableStateOf(student?.feesTotal?.toString() ?: "50000.0") }
    var scores by remember { mutableStateOf(student?.scores ?: emptyList<SubjectScore>()) }
    val focusManager = LocalFocusManager.current

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("PUPIL IDENTITY FORM", fontWeight = FontWeight.Black) },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(24.dp).verticalScroll(rememberScrollState())) {
            FormSectionTitle("CORE DATA")
            OutlinedTextField(
                value = id, 
                onValueChange = { id = it }, 
                label = { Text("Registration ID") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp), 
                enabled = student == null,
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
                label = { Text("Legal Name") }, 
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
            FormSectionTitle("ACADEMICS")
            Row {
                Box(modifier = Modifier.weight(1f)) {
                    var expanded by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = grade, 
                        onValueChange = {}, 
                        label = { Text("Class") }, 
                        readOnly = true, 
                        modifier = Modifier.fillMaxWidth(), 
                        shape = RoundedCornerShape(16.dp), 
                        trailingIcon = { IconButton(onClick = { expanded = true }) { Icon(Icons.Default.ArrowDropDown, null) } }, 
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black, 
                            unfocusedTextColor = Color.Black,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        listOf("Nursery 1", "Nursery 2", "Primary 1", "Primary 2", "Primary 3", "Primary 4", "Primary 5", "Primary 6").forEach { g ->
                            DropdownMenuItem(text = { Text(g) }, onClick = { grade = g; expanded = false })
                        }
                    }
                }
                // Hidden year for primary system as Class covers it
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Box(modifier = Modifier.weight(1f)) {
                    var expanded by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = gender, 
                        onValueChange = {}, 
                        label = { Text("Gender") }, 
                        readOnly = true, 
                        modifier = Modifier.fillMaxWidth(), 
                        shape = RoundedCornerShape(16.dp), 
                        trailingIcon = { IconButton(onClick = { expanded = true }) { Icon(Icons.Default.ArrowDropDown, null) } }, 
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black, 
                            unfocusedTextColor = Color.Black,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        listOf("Male", "Female").forEach { g -> DropdownMenuItem(text = { Text(g) }, onClick = { gender = g; expanded = false }) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            FormSectionTitle("GUARDIAN CONTACT")
            OutlinedTextField(
                value = guardianName, 
                onValueChange = { guardianName = it }, 
                label = { Text("Guardian Name") }, 
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
                value = guardianPhone, 
                onValueChange = { guardianPhone = it }, 
                label = { Text("Phone Number") }, 
                modifier = Modifier.fillMaxWidth(), 
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, 
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(24.dp))
            FormSectionTitle("FINANCE")
            Row {
                OutlinedTextField(
                    value = feesTotal, 
                    onValueChange = { feesTotal = it }, 
                    label = { Text("Fees") }, 
                    modifier = Modifier.weight(1f), 
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black, 
                        unfocusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.width(16.dp))
                OutlinedTextField(
                    value = feesPaid, 
                    onValueChange = { feesPaid = it }, 
                    label = { Text("Paid") }, 
                    modifier = Modifier.weight(1f), 
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { 
                        if (id.isNotBlank() && name.isNotBlank()) {
                            val updated = student?.copy(
                                id = id, name = name, grade = grade, gender = gender,
                                guardianName = guardianName, guardianPhone = guardianPhone,
                                feesPaid = feesPaid.toDoubleOrNull() ?: 0.0,
                                feesTotal = feesTotal.toDoubleOrNull() ?: 0.0,
                                scores = scores
                            ) ?: Student(
                                id = id, name = name, grade = grade, gender = gender,
                                guardianName = guardianName, guardianPhone = guardianPhone,
                                feesPaid = feesPaid.toDoubleOrNull() ?: 0.0,
                                feesTotal = feesTotal.toDoubleOrNull() ?: 0.0,
                                scores = scores
                            )
                            onSave(updated)
                        }
                    }),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black, 
                        unfocusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            FormSectionTitle("ACADEMIC PERFORMANCE")
            scores.forEachIndexed { index, subjectScore ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    OutlinedTextField(
                        value = subjectScore.subject,
                        onValueChange = { newSub ->
                            scores = scores.toMutableList().apply {
                                this[index] = subjectScore.copy(subject = newSub)
                            }
                        },
                        label = { Text("Subject") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = if (subjectScore.score == 0) "" else subjectScore.score.toString(),
                        onValueChange = { newScore ->
                            scores = scores.toMutableList().apply {
                                this[index] = subjectScore.copy(score = newScore.toIntOrNull() ?: 0)
                            }
                        },
                        label = { Text("Score") },
                        modifier = Modifier.width(100.dp),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )
                    IconButton(onClick = {
                        scores = scores.toMutableList().apply { removeAt(index) }
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color.Red)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            TextButton(
                onClick = { scores = scores + SubjectScore("", 0) },
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF800000))
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("ADD SUBJECT SCORE")
            }

            Spacer(modifier = Modifier.height(48.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f).height(64.dp), shape = RoundedCornerShape(20.dp)) {
                    Text("BACK", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { 
                        if (id.isNotBlank() && name.isNotBlank()) {
                            val updated = student?.copy(
                                id = id, name = name, grade = grade, gender = gender,
                                guardianName = guardianName, guardianPhone = guardianPhone,
                                feesPaid = feesPaid.toDoubleOrNull() ?: 0.0,
                                feesTotal = feesTotal.toDoubleOrNull() ?: 0.0,
                                scores = scores
                            ) ?: Student(
                                id = id, name = name, grade = grade, gender = gender,
                                guardianName = guardianName, guardianPhone = guardianPhone,
                                feesPaid = feesPaid.toDoubleOrNull() ?: 0.0,
                                feesTotal = feesTotal.toDoubleOrNull() ?: 0.0,
                                scores = scores
                            )
                            onSave(updated)
                        }
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
