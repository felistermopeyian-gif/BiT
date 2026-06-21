package com.example.studentmanagementapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.security.MessageDigest

@Entity(tableName = "users")
@Serializable
data class User(
    @PrimaryKey val userId: Int = 0,
    val username: String,
    val passwordHash: String
)

object SecurityUtils {
    fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }
}
