package com.brandonkoeck.school_records.service;

import com.brandonkoeck.school_records.exception.StudentNotFoundException;
import com.brandonkoeck.school_records.model.Student;
import com.brandonkoeck.school_records.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id); // throws if missing
        existing.setName(updated.getName());
        existing.setGradeLevel(updated.getGradeLevel());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {
        getStudentById(id); // make sure it exists
        studentRepository.deleteById(id);
    }

}
