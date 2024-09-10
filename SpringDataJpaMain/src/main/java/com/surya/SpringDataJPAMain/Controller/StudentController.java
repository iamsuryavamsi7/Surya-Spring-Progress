package com.surya.SpringDataJPAMain.Controller;

import com.surya.SpringDataJPAMain.DTO.StudentDTO;
import com.surya.SpringDataJPAMain.DTO.StudentResponseDTO;
import com.surya.SpringDataJPAMain.DTO.StudentSchoolDTO;
import com.surya.SpringDataJPAMain.Entity.Student;
import com.surya.SpringDataJPAMain.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> saveStudent(
            @RequestBody StudentDTO request
    ){

        StudentResponseDTO savedStudent = studentService.saveStudent(request);

        return ResponseEntity.ok(savedStudent);

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> fetchAllStudents(){

        List<Student> fetchedStudents = studentService.fetchAllStudents();

        return ResponseEntity.ok(fetchedStudents);

    }

    @GetMapping("/students/{student-id}")
    public ResponseEntity<Student> fetchStudentById(
            @PathVariable("student-id") Long id
    ){

        Student fetchedStudent = studentService.fetchStudentById(id);

        return ResponseEntity.ok(fetchedStudent);

    }

    @GetMapping("/students/search/{student-name}")
    public ResponseEntity<List<Student>> fetchStudentByFirstName(
            @PathVariable("student-name") String firstName
    ){

        List<Student> fetchedStudent = studentService.fetchStudentByFirstName(firstName);

        return ResponseEntity.ok(fetchedStudent);

    }

    @DeleteMapping("/students/{student-id}")
    public ResponseEntity<String> deleteStudentById(
            @PathVariable("student-id") Long id
    ){

        String studentDeleted = studentService.deleteStudentById(id);

        return ResponseEntity.ok(studentDeleted);

    }

    @PutMapping("/students/{student-id}")
    public ResponseEntity<Student> updateStudentById(
            @PathVariable("student-id") Long id, @RequestBody Student request
    ){

        Student updatedStudent = studentService.updateStudentById(id, request);

        return ResponseEntity.ok(updatedStudent);

    }

    @GetMapping("/students/school/{id}")
    public ResponseEntity<List<StudentSchoolDTO>> fetchStudentsBySchoolId(
            Long id
    ){

        List<StudentSchoolDTO> fetchedStudents = studentService.fetchStudentsBySchooId(id);

        return ResponseEntity.ok(fetchedStudents);

    }

}
