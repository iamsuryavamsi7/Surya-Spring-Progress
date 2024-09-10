package com.surya.SpringDataJPAMain.Repo;

import com.surya.SpringDataJPAMain.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {


    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);

    @Query(
            value = "SELECT * FROM student_table WHERE school_id = 2",
            nativeQuery = true
    )
    List<Student> findBySchoolById(Long id);
}
