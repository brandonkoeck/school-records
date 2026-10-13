package com.brandonkoeck.school_records.repository;

import com.brandonkoeck.school_records.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
