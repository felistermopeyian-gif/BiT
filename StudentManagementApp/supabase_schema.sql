-- SQL Schema for Osuyai Academy Student Management App (Week 7 Compliant)

-- 1. Students Table (Matches Week 7 Checklist)
CREATE TABLE IF NOT EXISTS students (
    id TEXT PRIMARY KEY, -- StudentID
    name TEXT NOT NULL,
    grade TEXT NOT NULL, -- Course (BIT, BBIT, etc.)
    year INTEGER DEFAULT 1, -- Study Year
    gender TEXT DEFAULT 'Male',
    guardianName TEXT,
    guardianPhone TEXT, -- PhoneNumber
    feesPaid DOUBLE PRECISION DEFAULT 0.0,
    feesTotal DOUBLE PRECISION DEFAULT 0.0,
    email TEXT,
    admissionDate BIGINT DEFAULT (extract(epoch from now()) * 1000),
    status TEXT DEFAULT 'Active',
    attendanceToday BOOLEAN DEFAULT false,
    scores JSONB DEFAULT '[]'::jsonb
);

-- 2. Staff Table
CREATE TABLE IF NOT EXISTS staff (
    id TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    role TEXT NOT NULL,
    email TEXT,
    phone TEXT,
    salary DOUBLE PRECISION DEFAULT 0.0,
    bonus DOUBLE PRECISION DEFAULT 0.0,
    deductions DOUBLE PRECISION DEFAULT 0.0,
    paymentStatus TEXT DEFAULT 'Unpaid',
    bankName TEXT,
    accountNumber TEXT,
    joinDate BIGINT DEFAULT (extract(epoch from now()) * 1000),
    attendanceToday BOOLEAN DEFAULT false,
    bio TEXT DEFAULT 'Dedicated educator at Osuyai Academy.'
);

-- 3. Attendance Records Table (Matches Week 7 Checklist)
CREATE TABLE IF NOT EXISTS attendance_records (
    attendanceId SERIAL PRIMARY KEY, -- AttendanceID (PK)
    studentId TEXT REFERENCES students(id) ON DELETE CASCADE, -- StudentID (FK)
    date BIGINT DEFAULT (extract(epoch from now()) * 1000),
    isPresent BOOLEAN NOT NULL,
    status TEXT NOT NULL -- Status (Present/Absent)
);

-- 4. Users Table (Matches Week 7 Checklist)
CREATE TABLE IF NOT EXISTS users (
    userId SERIAL PRIMARY KEY, -- UserID (PK)
    username TEXT UNIQUE NOT NULL,
    passwordHash TEXT NOT NULL -- Hashed Password Evidence
);

-- Policy to allow all access
CREATE POLICY "Allow all access" ON students FOR ALL USING (true) WITH CHECK (true);
CREATE POLICY "Allow all access" ON staff FOR ALL USING (true) WITH CHECK (true);
CREATE POLICY "Allow all access" ON attendance_records FOR ALL USING (true) WITH CHECK (true);
CREATE POLICY "Allow all access" ON users FOR ALL USING (true) WITH CHECK (true);
