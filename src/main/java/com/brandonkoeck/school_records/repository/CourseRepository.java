package com.brandonkoeck.school_records.repository;

import com.brandonkoeck.school_records.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
