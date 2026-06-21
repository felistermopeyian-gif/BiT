package com.example.studentmanagementapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementapp.data.remote.AcademyNews
import com.example.studentmanagementapp.data.repository.UserRole
import com.example.studentmanagementapp.model.Staff
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.ui.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    userRole: UserRole,
    students: List<Student>,
    staffList: List<Staff>,
    newsList: List<AcademyNews>,
    isNewsLoading: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onUpdateStudent: (Student) -> Unit,
    onUpdateStaff: (Staff) -> Unit,
    onAddStudent: () -> Unit,
    onEditStudent: (Student) -> Unit,
    onDeleteStudent: (String) -> Unit,
    onViewAttendance: (Student) -> Unit,
    onViewProfile: (Student) -> Unit,
    onAddStaff: () -> Unit,
    onEditStaff: (Staff) -> Unit,
    onDeleteStaff: (String) -> Unit,
    onViewReports: () -> Unit,
    onViewApiUsers: () -> Unit,
    onMenuClick: () -> Unit,
    onLogout: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    
    val filteredStudents = if (userRole == UserRole.PARENT) {
        students.filter { it.id == searchQuery || searchQuery.isBlank() } // Simplification for now
    } else students

    val filteredStaff = staffList

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color(0xFF800000))) {
                CenterAlignedTopAppBar(
                    title = { Text(if (selectedTab == 0) "PUPIL DASHBOARD" else "OSUYAI CAMPUS HUB", fontWeight = FontWeight.Black, fontSize = 18.sp) },
                    navigationIcon = { IconButton(onClick = onMenuClick) { Icon(Icons.Default.Menu, null) } },
                    actions = { IconButton(onClick = onViewReports) { Icon(Icons.Default.Analytics, null) } },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent, titleContentColor = Color.White, actionIconContentColor = Color.White)
                )
                
                NoticeBoard()

                LazyRow(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    item { SummaryChip("Total Pupils", students.size.toString(), Icons.Default.Face) }
                    if (userRole == UserRole.ADMIN || userRole == UserRole.STAFF) {
                        item { SummaryChip("Total Staff", staffList.size.toString(), Icons.Default.Groups) }
                    }
                    item { SummaryChip("Attendance", "${(students.count { it.attendanceToday } + staffList.count { it.attendanceToday })} Present", Icons.Default.EventAvailable) }
                    if (userRole == UserRole.ADMIN || userRole == UserRole.ACCOUNTANT) {
                        item { SummaryChip("Fee Revenue", "₦${students.sumOf { it.feesPaid }.toInt()}", Icons.Default.Payments) }
                    }
                }

                TabRow(selectedTabIndex = selectedTab, containerColor = Color.Transparent, contentColor = Color.White, indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedTab]), color = Color.White, height = 4.dp)
                }) {
                    Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("ACADEMY", fontWeight = FontWeight.Bold) })
                    if (userRole == UserRole.ADMIN || userRole == UserRole.ACCOUNTANT) {
                        Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("OPERATIONS", fontWeight = FontWeight.Bold) })
                    }
                    Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }, text = { Text("NEWS", fontWeight = FontWeight.Bold) })
                }
            }
        },
        floatingActionButton = {
            if (selectedTab < 2 && userRole == UserRole.ADMIN) {
                ExtendedFloatingActionButton(
                    onClick = { if (selectedTab == 0) onAddStudent() else onAddStaff() },
                    containerColor = Color(0xFF800000),
                    contentColor = Color.White,
                    shape = RoundedCornerShape(20.dp),
                    icon = { Icon(if (selectedTab == 0) Icons.Default.PersonAddAlt1 else Icons.Default.GroupAdd, null) },
                    text = { Text(if (selectedTab == 0) "NEW PUPIL" else "NEW STAFF", fontWeight = FontWeight.Bold) }
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color(0xFFF8FAFC))) {
            Column {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    placeholder = { Text("Search records...") },
                    leadingIcon = { Icon(Icons.Default.Search, null, tint = Color(0xFF800000)) },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White, focusedTextColor = Color.Black, unfocusedTextColor = Color.Black)
                )

                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = onAddStudent, modifier = Modifier.weight(1f), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))) {
                        Text("REGISTER", fontSize = 10.sp)
                    }
                    Button(onClick = onViewReports, modifier = Modifier.weight(1f), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))) {
                        Text("REPORTS", fontSize = 10.sp)
                    }
                    Button(onClick = onViewApiUsers, modifier = Modifier.weight(1f), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006400))) {
                        Text("API USERS", fontSize = 10.sp)
                    }
                }

                if (selectedTab == 0) {
                    if (filteredStudents.isEmpty()) EmptyStateView("Academy is Quiet") else {
                        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            items(filteredStudents) { student ->
                                SmartStudentCard(
                                    student = student, 
                                    onEdit = { onEditStudent(student) }, 
                                    onDelete = { onDeleteStudent(student.id) },
                                    onAttendanceToggle = { onUpdateStudent(student.copy(attendanceToday = !student.attendanceToday)) },
                                    onViewHistory = { onViewAttendance(student) },
                                    onViewProfile = { onViewProfile(student) }
                                )
                            }
                        }
                    }
                } else if (selectedTab == 1) {
                    if (filteredStaff.isEmpty()) EmptyStateView("Operations Halted") else {
                        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            items(filteredStaff) { staff ->
                                SmartStaffCard(
                                    staff = staff, 
                                    onEdit = { onEditStaff(staff) }, 
                                    onDelete = { onDeleteStaff(staff.id) },
                                    onAttendanceToggle = { onUpdateStaff(staff.copy(attendanceToday = !staff.attendanceToday)) },
                                    onViewHistory = { onViewAttendance(Student(id = staff.id, name = staff.name, grade = staff.role, feesPaid = 0.0, feesTotal = 0.0)) } 
                                )
                            }
                        }
                    }
                } else {
                    if (isNewsLoading) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(color = Color(0xFF800000))
                        }
                    } else if (newsList.isEmpty()) {
                        EmptyStateView("No News Today")
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            items(newsList) { news ->
                                NewsCard(news)
                            }
                        }
                    }
                }
            }
        }
    }
}
