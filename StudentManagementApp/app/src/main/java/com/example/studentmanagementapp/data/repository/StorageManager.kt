package com.example.studentmanagementapp.data.repository

import android.content.Context
import com.example.studentmanagementapp.data.local.AppDatabase
import com.example.studentmanagementapp.model.AttendanceRecord
import com.example.studentmanagementapp.model.Staff
import com.example.studentmanagementapp.model.Student
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

enum class UserRole {
    ADMIN, STAFF, ACCOUNTANT, PARENT
}

class StorageManager(context: Context) {

    private val database = AppDatabase.getDatabase(context)
    private val studentDao = database.studentDao()
    private val staffDao = database.staffDao()
    private val attendanceDao = database.attendanceDao()
    private val supabase = SupabaseRepository()
    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Helper to check if Supabase is "configured" (not using placeholders)
    private fun isSupabaseConfigured(): Boolean {
        // This is a simple check, in a real app you'd have better logic
        return true 
    }

    // --- Attendance Methods ---
    suspend fun logAttendance(studentId: String, isPresent: Boolean) = withContext(Dispatchers.IO) {
        val record = AttendanceRecord(studentId = studentId, isPresent = isPresent)
        attendanceDao.logAttendance(record)
        try {
            supabase.logAttendance(record)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun getAttendanceHistory(studentId: String): List<AttendanceRecord> = withContext(Dispatchers.IO) {
        try {
            supabase.getAttendanceForStudent(studentId)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}. Falling back to local.")
            attendanceDao.getAttendanceForStudent(studentId)
        }
    }

    // --- Shared Preferences for Login ---
    fun setLoggedIn(isLoggedIn: Boolean, role: UserRole = UserRole.ADMIN, username: String = "") {
        prefs.edit().apply {
            putBoolean("is_logged_in", isLoggedIn)
            putString("user_role", role.name)
            putString("user_name", username)
            apply()
        }
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }

    fun getUserRole(): UserRole {
        val roleName = prefs.getString("user_role", UserRole.ADMIN.name)
        return try { UserRole.valueOf(roleName!!) } catch (e: Exception) { UserRole.ADMIN }
    }

    fun getUserName(): String {
        return prefs.getString("user_name", "") ?: ""
    }

    fun logout() {
        prefs.edit().clear().apply()
    }

    // --- Student Methods ---
    suspend fun addStudent(student: Student) = withContext(Dispatchers.IO) {
        studentDao.insertStudent(student)
        try {
            supabase.insertStudent(student)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun updateStudent(student: Student) = withContext(Dispatchers.IO) {
        studentDao.updateStudent(student)
        try {
            supabase.updateStudent(student)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun deleteStudent(studentId: String) = withContext(Dispatchers.IO) {
        studentDao.deleteStudentById(studentId)
        try {
            supabase.deleteStudent(studentId)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun loadStudents(): List<Student> = withContext(Dispatchers.IO) {
        try {
            val remote = supabase.getStudents()
            // Optional: Sync remote to local
            remote.forEach { studentDao.insertStudent(it) }
            remote
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}. Falling back to local.")
            studentDao.getAllStudents()
        }
    }

    suspend fun searchStudents(query: String): List<Student> = withContext(Dispatchers.IO) {
        try {
            supabase.searchStudents(query)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}. Falling back to local.")
            studentDao.searchStudents(query)
        }
    }

    // --- Staff Methods ---
    suspend fun addStaff(staff: Staff) = withContext(Dispatchers.IO) {
        staffDao.insertStaff(staff)
        try {
            supabase.insertStaff(staff)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun updateStaff(staff: Staff) = withContext(Dispatchers.IO) {
        staffDao.updateStaff(staff)
        try {
            supabase.updateStaff(staff)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun deleteStaff(staffId: String) = withContext(Dispatchers.IO) {
        staffDao.deleteStaffById(staffId)
        try {
            supabase.deleteStaff(staffId)
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}")
        }
    }

    suspend fun loadStaff(): List<Staff> = withContext(Dispatchers.IO) {
        try {
            val remote = supabase.getStaff()
            remote.forEach { staffDao.insertStaff(it) }
            remote
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}. Falling back to local.")
            staffDao.getAllStaff()
        }
    }

    suspend fun searchStaff(query: String): List<Staff> = withContext(Dispatchers.IO) {
        try {
            supabase.getStaff().filter { it.name.contains(query, true) || it.id.contains(query, true) }
        } catch (e: Exception) {
            Log.e("StorageManager", "Supabase Error: ${e.message}. Falling back to local.")
            staffDao.searchStaff(query)
        }
    }
}
