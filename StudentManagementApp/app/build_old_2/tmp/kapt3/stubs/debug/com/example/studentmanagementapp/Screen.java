package com.example.studentmanagementapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/studentmanagementapp/Screen;", "", "<init>", "()V", "Login", "SignUp", "ForgotPassword", "Dashboard", "StudentForm", "StaffForm", "Lcom/example/studentmanagementapp/Screen$Dashboard;", "Lcom/example/studentmanagementapp/Screen$ForgotPassword;", "Lcom/example/studentmanagementapp/Screen$Login;", "Lcom/example/studentmanagementapp/Screen$SignUp;", "Lcom/example/studentmanagementapp/Screen$StaffForm;", "Lcom/example/studentmanagementapp/Screen$StudentForm;", "app_debug"})
public abstract class Screen {
    
    private Screen() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/studentmanagementapp/Screen$Dashboard;", "Lcom/example/studentmanagementapp/Screen;", "<init>", "()V", "app_debug"})
    public static final class Dashboard extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.studentmanagementapp.Screen.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/studentmanagementapp/Screen$ForgotPassword;", "Lcom/example/studentmanagementapp/Screen;", "<init>", "()V", "app_debug"})
    public static final class ForgotPassword extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.studentmanagementapp.Screen.ForgotPassword INSTANCE = null;
        
        private ForgotPassword() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/studentmanagementapp/Screen$Login;", "Lcom/example/studentmanagementapp/Screen;", "<init>", "()V", "app_debug"})
    public static final class Login extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.studentmanagementapp.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/studentmanagementapp/Screen$SignUp;", "Lcom/example/studentmanagementapp/Screen;", "<init>", "()V", "app_debug"})
    public static final class SignUp extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.studentmanagementapp.Screen.SignUp INSTANCE = null;
        
        private SignUp() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/studentmanagementapp/Screen$StaffForm;", "Lcom/example/studentmanagementapp/Screen;", "staff", "Lcom/example/studentmanagementapp/Staff;", "<init>", "(Lcom/example/studentmanagementapp/Staff;)V", "getStaff", "()Lcom/example/studentmanagementapp/Staff;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class StaffForm extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.Nullable()
        private final com.example.studentmanagementapp.Staff staff = null;
        
        public StaffForm(@org.jetbrains.annotations.Nullable()
        com.example.studentmanagementapp.Staff staff) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.studentmanagementapp.Staff getStaff() {
            return null;
        }
        
        public StaffForm() {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.studentmanagementapp.Staff component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.studentmanagementapp.Screen.StaffForm copy(@org.jetbrains.annotations.Nullable()
        com.example.studentmanagementapp.Staff staff) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/studentmanagementapp/Screen$StudentForm;", "Lcom/example/studentmanagementapp/Screen;", "student", "Lcom/example/studentmanagementapp/Student;", "<init>", "(Lcom/example/studentmanagementapp/Student;)V", "getStudent", "()Lcom/example/studentmanagementapp/Student;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class StudentForm extends com.example.studentmanagementapp.Screen {
        @org.jetbrains.annotations.Nullable()
        private final com.example.studentmanagementapp.Student student = null;
        
        public StudentForm(@org.jetbrains.annotations.Nullable()
        com.example.studentmanagementapp.Student student) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.studentmanagementapp.Student getStudent() {
            return null;
        }
        
        public StudentForm() {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.studentmanagementapp.Student component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.studentmanagementapp.Screen.StudentForm copy(@org.jetbrains.annotations.Nullable()
        com.example.studentmanagementapp.Student student) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}