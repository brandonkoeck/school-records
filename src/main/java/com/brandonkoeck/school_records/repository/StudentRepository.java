package com.brandonkoeck.school_records.repository;

import com.brandonkoeck.school_records.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
