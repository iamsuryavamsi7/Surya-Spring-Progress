package com.surya.SpringDataJPAMain.Service;

import com.surya.SpringDataJPAMain.DTO.StudentDTO;
import com.surya.SpringDataJPAMain.DTO.StudentResponseDTO;
import com.surya.SpringDataJPAMain.DTO.StudentSchoolDTO;
import com.surya.SpringDataJPAMain.Entity.School;
import com.surya.SpringDataJPAMain.Entity.Student;
import com.surya.SpringDataJPAMain.Repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentResponseDTO saveStudent(StudentDTO request) {

        School school = School.builder()
                .id(request.getSchoolId())
                .build();

        Student savingStudent = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .age(request.getAge())
                .creationDate(new Date(System.currentTimeMillis()))
                .school(school)
                .build();

        Student savedStudent = studentRepo.save(savingStudent);

        return new StudentResponseDTO(
                savedStudent.getFirstName(),
                savedStudent.getLastName(),
                savedStudent.getEmail(),
                savedStudent.getAge()
        );

    }

    public List<Student> fetchAllStudents() {

        return studentRepo.findAll();

    }

    public Student fetchStudentById(Long id) {

        return studentRepo.findById(id).orElse(new Student());

    }

    public List<Student> fetchStudentByFirstName(String firstName) {

        return studentRepo.findByFirstNameContainingIgnoreCase(firstName);

    }

    public String deleteStudentById(Long id) {

        studentRepo.deleteById(id);

        return "Student Deleted";

    }

    public Student updateStudentById(Long id, Student request) {

        Student fetchedStudent = studentRepo.findById(id).get();

        if ( fetchedStudent.getEmail() != null ) {

            fetchedStudent.setFirstName(request.getFirstName());

            fetchedStudent.setLastName(request.getLastName());

            fetchedStudent.setAge(request.getAge());

            return studentRepo.save(fetchedStudent);

        }

        throw new RuntimeException("Student Not Found");

    }

    private StudentSchoolDTO toStudentSchoolDTO(Student student){

        return new StudentSchoolDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge()
        );

    }

    public List<StudentSchoolDTO> fetchStudentsBySchooId(Long id) {

        return studentRepo.findBySchoolById(id)
                .stream()
                .map(this::toStudentSchoolDTO)
                .collect(Collectors.toList());

    }

}
