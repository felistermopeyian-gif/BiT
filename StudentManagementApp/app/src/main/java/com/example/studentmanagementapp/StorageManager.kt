package com.example.studentmanagementapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class StorageManager(context: Context) {

    private val database = AppDatabase.getDatabase(context)
    private val studentDao = database.studentDao()
    private val staffDao = database.staffDao()
    private val attendanceDao = database.attendanceDao()
    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // --- Attendance Methods ---
    fun logAttendance(studentId: String, isPresent: Boolean) = runBlocking {
        withContext(Dispatchers.IO) {
            attendanceDao.logAttendance(AttendanceRecord(studentId = studentId, isPresent = isPresent))
        }
    }

    fun getAttendanceHistory(studentId: String): List<AttendanceRecord> = runBlocking {
        withContext(Dispatchers.IO) {
            attendanceDao.getAttendanceForStudent(studentId)
        }
    }

    // --- Shared Preferences for Login ---
    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean("is_logged_in", isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }

    // --- Student Methods ---
    fun addStudent(student: Student) = runBlocking {
        withContext(Dispatchers.IO) {
            studentDao.insertStudent(student)
        }
    }

    fun updateStudent(student: Student) = runBlocking {
        withContext(Dispatchers.IO) {
            studentDao.updateStudent(student)
        }
    }

    fun deleteStudent(studentId: String) = runBlocking {
        withContext(Dispatchers.IO) {
            studentDao.deleteStudentById(studentId)
        }
    }

    fun loadStudents(): List<Student> = runBlocking {
        withContext(Dispatchers.IO) {
            studentDao.getAllStudents()
        }
    }

    fun searchStudents(query: String): List<Student> = runBlocking {
        withContext(Dispatchers.IO) {
            studentDao.searchStudents(query)
        }
    }

    // --- Staff Methods ---
    fun addStaff(staff: Staff) = runBlocking {
        withContext(Dispatchers.IO) {
            staffDao.insertStaff(staff)
        }
    }

    fun updateStaff(staff: Staff) = runBlocking {
        withContext(Dispatchers.IO) {
            staffDao.updateStaff(staff)
        }
    }

    fun deleteStaff(staffId: String) = runBlocking {
        withContext(Dispatchers.IO) {
            staffDao.deleteStaffById(staffId)
        }
    }

    fun loadStaff(): List<Staff> = runBlocking {
        withContext(Dispatchers.IO) {
            staffDao.getAllStaff()
        }
    }

    fun searchStaff(query: String): List<Staff> = runBlocking {
        withContext(Dispatchers.IO) {
            staffDao.searchStaff(query)
        }
    }
}
