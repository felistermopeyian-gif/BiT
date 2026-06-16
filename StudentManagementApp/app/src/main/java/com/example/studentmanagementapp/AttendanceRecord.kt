package com.example.studentmanagementapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "attendance_records")
data class AttendanceRecord(
    @PrimaryKey(autoGenerate = true) val recordId: Int = 0,
    val studentId: String,
    val date: Long = System.currentTimeMillis(),
    val isPresent: Boolean
) {
    val formattedDate: String 
        get() = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date(date))
}
