package com.brandonkoeck.school_records.config;

import com.brandonkoeck.school_records.model.Course;
import com.brandonkoeck.school_records.model.Student;
import com.brandonkoeck.school_records.repository.CourseRepository;
import com.brandonkoeck.school_records.repository.EnrollmentRepository;
import com.brandonkoeck.school_records.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public DataLoader(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public void run(String... args) {
        if (studentRepository.count() == 0) {
            studentRepository.save(new Student("Matthew", 9));
            studentRepository.save(new Student("Mark", 9));
            studentRepository.save(new Student("Luke", 10));
            studentRepository.save(new Student("John", 11));
            studentRepository.save(new Student("Nehemiah", 12));
        }
        if (courseRepository.count() == 0) {
            courseRepository.save(new Course("American History", "HIS103"));
            courseRepository.save(new Course("Creative Writing", "ENG107"));
            courseRepository.save(new Course("Linear Algebra", "MAT205"));
        }
    }
}
