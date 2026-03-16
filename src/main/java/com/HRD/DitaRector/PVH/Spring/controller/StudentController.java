package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController

@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @Operation(summary = "Get All students")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Student> studentList = studentService.getAllStudent(page, size);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(true)
                .messages("Students retrieved successfully")
                .status(HttpStatus.OK)
                .payload(studentList)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get student by ID")
    @GetMapping("{student-id}")
    public ResponseEntity<Student> getStudentByIdById(@PathVariable("student-id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }




}
