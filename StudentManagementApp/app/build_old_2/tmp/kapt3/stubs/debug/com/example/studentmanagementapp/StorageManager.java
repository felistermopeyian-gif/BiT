package com.example.studentmanagementapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0013J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u0017\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/studentmanagementapp/StorageManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "database", "Lcom/example/studentmanagementapp/AppDatabase;", "studentDao", "Lcom/example/studentmanagementapp/StudentDao;", "staffDao", "Lcom/example/studentmanagementapp/StaffDao;", "addStudent", "", "student", "Lcom/example/studentmanagementapp/Student;", "updateStudent", "deleteStudent", "studentId", "", "loadStudents", "", "searchStudents", "query", "addStaff", "staff", "Lcom/example/studentmanagementapp/Staff;", "updateStaff", "deleteStaff", "staffId", "loadStaff", "searchStaff", "app_debug"})
public final class StorageManager {
    @org.jetbrains.annotations.NotNull()
    private final com.example.studentmanagementapp.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.studentmanagementapp.StudentDao studentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.studentmanagementapp.StaffDao staffDao = null;
    
    public StorageManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void addStudent(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Student student) {
    }
    
    public final void updateStudent(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Student student) {
    }
    
    public final void deleteStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.studentmanagementapp.Student> loadStudents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.studentmanagementapp.Student> searchStudents(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    public final void addStaff(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Staff staff) {
    }
    
    public final void updateStaff(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Staff staff) {
    }
    
    public final void deleteStaff(@org.jetbrains.annotations.NotNull()
    java.lang.String staffId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.studentmanagementapp.Staff> loadStaff() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.studentmanagementapp.Staff> searchStaff(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}