package com.example.studentmanagementapp

import android.content.Context
import androidx.room.*

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    suspend fun getAllStudents(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Query("DELETE FROM students WHERE id = :id")
    suspend fun deleteStudentById(id: String)

    @Query("SELECT * FROM students WHERE name LIKE '%' || :query || '%' OR id LIKE '%' || :query || '%'")
    suspend fun searchStudents(query: String): List<Student>
}

@Dao
interface StaffDao {
    @Query("SELECT * FROM staff")
    suspend fun getAllStaff(): List<Staff>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStaff(staff: Staff)

    @Update
    suspend fun updateStaff(staff: Staff)

    @Query("DELETE FROM staff WHERE id = :id")
    suspend fun deleteStaffById(id: String)

    @Query("SELECT * FROM staff WHERE name LIKE '%' || :query || '%' OR id LIKE '%' || :query || '%'")
    suspend fun searchStaff(query: String): List<Staff>
}

@Dao
interface AttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun logAttendance(record: AttendanceRecord)

    @Query("SELECT * FROM attendance_records WHERE studentId = :studentId ORDER BY date DESC")
    suspend fun getAttendanceForStudent(studentId: String): List<AttendanceRecord>

    @Query("SELECT * FROM attendance_records WHERE date >= :startOfDay AND date <= :endOfDay")
    suspend fun getAttendanceByDate(startOfDay: Long, endOfDay: Long): List<AttendanceRecord>
}

@Database(entities = [Student::class, Staff::class, AttendanceRecord::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun staffDao(): StaffDao
    abstract fun attendanceDao(): AttendanceDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "school_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
