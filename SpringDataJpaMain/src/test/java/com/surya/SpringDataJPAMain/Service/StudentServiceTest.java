package com.surya.SpringDataJPAMain.Service;

import com.surya.SpringDataJPAMain.Repo.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);

    }

}