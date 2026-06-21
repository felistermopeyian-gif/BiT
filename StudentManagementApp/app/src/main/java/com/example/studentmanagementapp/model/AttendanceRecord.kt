package com.example.studentmanagementapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "attendance_records")
@Serializable
data class AttendanceRecord(
    @PrimaryKey(autoGenerate = true) val attendanceId: Int = 0, // AttendanceID (PK)
    val studentId: String, // StudentID (FK)
    val date: Long = System.currentTimeMillis(),
    val isPresent: Boolean,
    val status: String = if (isPresent) "Present" else "Absent" // Status
) {
    val formattedDate: String 
        get() = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date(date))
}
