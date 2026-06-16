package com.example.studentmanagementapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class SubjectScore(
    val subject: String,
    val score: Int
)

@Entity(tableName = "students")
data class Student(
    @PrimaryKey val id: String,
    val name: String,
    val grade: String,
    val gender: String = "Male",
    val guardianName: String = "",
    val guardianPhone: String = "",
    val feesPaid: Double = 0.0,
    val feesTotal: Double = 0.0,
    val email: String = "",
    val admissionDate: Long = System.currentTimeMillis(),
    val status: String = "Active",
    val attendanceToday: Boolean = false,
    val scores: List<SubjectScore> = emptyList()
) {
    val averageScore: Double get() = if (scores.isEmpty()) 0.0 else scores.map { it.score }.average()
    val performanceLevel: String get() = when {
        averageScore >= 80 -> "Excellent"
        averageScore >= 60 -> "Good"
        averageScore >= 40 -> "Fair"
        else -> "Needs Attention"
    }
}

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSubjectScoreList(value: List<SubjectScore>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toSubjectScoreList(value: String): List<SubjectScore> {
        val listType = object : TypeToken<List<SubjectScore>>() {}.type
        return gson.fromJson(value, listType)
    }
}
