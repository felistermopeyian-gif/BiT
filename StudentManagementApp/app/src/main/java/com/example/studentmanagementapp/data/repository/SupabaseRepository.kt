package com.example.studentmanagementapp.data.repository

import com.example.studentmanagementapp.data.remote.SupabaseClient
import com.example.studentmanagementapp.model.AttendanceRecord
import com.example.studentmanagementapp.model.Staff
import com.example.studentmanagementapp.model.Student
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SupabaseRepository {

    private val postgrest = SupabaseClient.client.postgrest

    suspend fun getStudents(): List<Student> = withContext(Dispatchers.IO) {
        postgrest["students"].select().decodeList<Student>()
    }

    suspend fun insertStudent(student: Student) = withContext(Dispatchers.IO) {
        postgrest["students"].insert(student)
    }

    suspend fun updateStudent(student: Student) = withContext(Dispatchers.IO) {
        postgrest["students"].update(student) {
            filter {
                Student::id eq student.id
            }
        }
    }

    suspend fun deleteStudent(studentId: String) = withContext(Dispatchers.IO) {
        postgrest["students"].delete {
            filter {
                Student::id eq studentId
            }
        }
    }

    suspend fun searchStudents(query: String): List<Student> = withContext(Dispatchers.IO) {
        postgrest["students"].select {
            filter {
                or {
                    Student::name ilike "%$query%"
                    Student::id ilike "%$query%"
                }
            }
        }.decodeList<Student>()
    }

    suspend fun getStaff(): List<Staff> = withContext(Dispatchers.IO) {
        postgrest["staff"].select().decodeList<Staff>()
    }

    suspend fun insertStaff(staff: Staff) = withContext(Dispatchers.IO) {
        postgrest["staff"].insert(staff)
    }

    suspend fun updateStaff(staff: Staff) = withContext(Dispatchers.IO) {
        postgrest["staff"].update(staff) {
            filter {
                Staff::id eq staff.id
            }
        }
    }

    suspend fun deleteStaff(staffId: String) = withContext(Dispatchers.IO) {
        postgrest["staff"].delete {
            filter {
                Staff::id eq staffId
            }
        }
    }

    suspend fun logAttendance(record: AttendanceRecord) = withContext(Dispatchers.IO) {
        postgrest["attendance_records"].insert(record)
    }

    suspend fun getAttendanceForStudent(studentId: String): List<AttendanceRecord> = withContext(Dispatchers.IO) {
        postgrest["attendance_records"].select {
            filter {
                AttendanceRecord::studentId eq studentId
            }
        }.decodeList<AttendanceRecord>()
    }
}
