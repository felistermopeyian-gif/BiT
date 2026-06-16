package com.example.studentmanagementapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0011\u00c0\u0006\u0003"}, d2 = {"Lcom/example/studentmanagementapp/StudentDao;", "", "getAllStudents", "", "Lcom/example/studentmanagementapp/Student;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertStudent", "", "student", "(Lcom/example/studentmanagementapp/Student;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStudent", "deleteStudentById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchStudents", "query", "app_debug"})
@androidx.room.Dao()
public abstract interface StudentDao {
    
    @androidx.room.Query(value = "SELECT * FROM students")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllStudents(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.studentmanagementapp.Student>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertStudent(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Student student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStudent(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Student student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM students WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteStudentById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM students WHERE name LIKE \'%\' || :query || \'%\' OR id LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchStudents(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.studentmanagementapp.Student>> $completion);
}