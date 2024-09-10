package com.surya.SpringDataJPAMain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "student_profile_table"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            length = 500
    )
    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    @JsonBackReference
    private Student student;

}
