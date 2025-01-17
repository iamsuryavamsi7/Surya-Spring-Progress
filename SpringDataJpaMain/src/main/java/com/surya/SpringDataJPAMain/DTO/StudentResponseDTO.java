package com.surya.SpringDataJPAMain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private String firstName;

    private String lastName;

    private String email;

    private int age;

}
