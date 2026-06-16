package com.example.studentmanagementapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0011\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a2\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u00f0\u0001\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0010H\u0007\u001a\b\u0010 \u001a\u00020\u0001H\u0007\u001a \u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0007\u001a:\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a:\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a6\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0012H\u0007\u001a\u0018\u00106\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020\u0012H\u0007\u001a\u0010\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u0012H\u0007\u001a\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u0012H\u0007\u001a4\u0010<\u001a\u00020\u00012\b\u0010\'\u001a\u0004\u0018\u00010\f2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a4\u0010?\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a$\u0010@\u001a\u00020\u00012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0016\u0010B\u001a\u00020\u00012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u00a8\u0006C"}, d2 = {"AppNavigation", "", "storageManager", "Lcom/example/studentmanagementapp/StorageManager;", "LoginScreen", "onLoginSuccess", "Lkotlin/Function0;", "onSignUp", "onForgotPassword", "DashboardScreen", "students", "", "Lcom/example/studentmanagementapp/Student;", "staffList", "Lcom/example/studentmanagementapp/Staff;", "newsList", "Lcom/example/studentmanagementapp/AcademyNews;", "searchQuery", "", "onSearchQueryChange", "Lkotlin/Function1;", "onUpdateStudent", "onUpdateStaff", "onAddStudent", "onEditStudent", "onDeleteStudent", "onAddStaff", "onEditStaff", "onDeleteStaff", "onLogout", "NewsCard", "news", "NoticeBoard", "SummaryChip", "label", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SmartStudentCard", "student", "onEdit", "onDelete", "onAttendanceToggle", "SmartStaffCard", "staff", "DigitalIDDialog", "name", "id", "sub", "isStudent", "", "onDismiss", "PerformanceBadge", "level", "InfoItem", "text", "EmptyStateView", "message", "FormSectionTitle", "title", "StudentFormScreen", "onSave", "onBack", "StaffFormScreen", "SignUpScreen", "onSignUpSuccess", "ForgotPasswordScreen", "app_debug"})
public final class MainActivityKt {
    
    @androidx.compose.runtime.Composable()
    public static final void AppNavigation(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.StorageManager storageManager) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoginScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoginSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignUp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onForgotPassword) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.studentmanagementapp.Student> students, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.studentmanagementapp.Staff> staffList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.studentmanagementapp.AcademyNews> newsList, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearchQueryChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Student, kotlin.Unit> onUpdateStudent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Staff, kotlin.Unit> onUpdateStaff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddStudent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Student, kotlin.Unit> onEditStudent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteStudent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddStaff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Staff, kotlin.Unit> onEditStaff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteStaff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NewsCard(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.AcademyNews news) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NoticeBoard() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SummaryChip(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SmartStudentCard(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Student student, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAttendanceToggle) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SmartStaffCard(@org.jetbrains.annotations.NotNull()
    com.example.studentmanagementapp.Staff staff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAttendanceToggle) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DigitalIDDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String sub, boolean isStudent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PerformanceBadge(@org.jetbrains.annotations.NotNull()
    java.lang.String level) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InfoItem(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyStateView(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FormSectionTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void StudentFormScreen(@org.jetbrains.annotations.Nullable()
    com.example.studentmanagementapp.Student student, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Student, kotlin.Unit> onSave, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void StaffFormScreen(@org.jetbrains.annotations.Nullable()
    com.example.studentmanagementapp.Staff staff, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.studentmanagementapp.Staff, kotlin.Unit> onSave, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SignUpScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignUpSuccess) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ForgotPasswordScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
}