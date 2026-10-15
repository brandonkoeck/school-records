package com.brandonkoeck.school_records.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student not found: " + id);
    }
}
