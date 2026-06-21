package com.example.studentmanagementapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "staff")
@Serializable
data class Staff(
    @PrimaryKey val id: String,
    val name: String,
    val role: String,
    val email: String = "",
    val phone: String = "",
    val salary: Double = 0.0,
    val bonus: Double = 0.0,
    val deductions: Double = 0.0,
    val paymentStatus: String = "Unpaid",
    val bankName: String = "",
    val accountNumber: String = "",
    val joinDate: Long = System.currentTimeMillis(),
    val attendanceToday: Boolean = false,
    val bio: String = "Dedicated educator at Osuyai Academy."
) {
    val netPay: Double get() = salary + bonus - deductions
}
