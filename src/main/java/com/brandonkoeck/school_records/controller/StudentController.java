package com.brandonkoeck.school_records.controller;

import com.brandonkoeck.school_records.model.Student;
import com.brandonkoeck.school_records.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() { // GET /students
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) { // GET /students/id
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // respond with 201 instead of 200
    public Student create(@RequestBody Student student) { // POST /students
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) { // PUT /students/id
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204: success, nothing to return
    public void delete(@PathVariable Long id) { // DELETE /students/id
        studentService.deleteStudent(id);
    }

}
