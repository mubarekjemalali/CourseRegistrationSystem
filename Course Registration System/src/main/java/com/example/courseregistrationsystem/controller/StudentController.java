package com.example.courseregistrationsystem.controller;

import com.example.courseregistrationsystem.service.StudentService;
import com.example.courseregistrationsystem.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // get all students
    @GetMapping("")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
    // get student by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    // add student
    @PostMapping("/")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        System.out.println("add student controller");
        System.out.println(studentDto);
        return ResponseEntity.ok().body(studentService.addStudent(studentDto));
    }
    // update student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int id, StudentDto studentDto) {
        return ResponseEntity.ok().body(studentService.updateStudent(id, studentDto));
    }
    // delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        return ResponseEntity.ok().body(studentService.deleteStudent(id));
    }
}
