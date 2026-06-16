package com.example.studentmanagementapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0007\u00c0\u0006\u0003"}, d2 = {"Lcom/example/studentmanagementapp/ApiService;", "", "getAcademyNews", "", "Lcom/example/studentmanagementapp/AcademyNews;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface ApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.studentmanagementapp.ApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "posts?_limit=5")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAcademyNews(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.studentmanagementapp.AcademyNews>> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/studentmanagementapp/ApiService$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/example/studentmanagementapp/ApiService;", "getInstance", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.Nullable()
        private static com.example.studentmanagementapp.ApiService INSTANCE;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.studentmanagementapp.ApiService getInstance() {
            return null;
        }
    }
}