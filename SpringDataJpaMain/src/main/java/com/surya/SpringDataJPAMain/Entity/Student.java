package com.surya.SpringDataJPAMain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(
        name = "student_table",
        uniqueConstraints = @UniqueConstraint(columnNames = {
                "email"
        })
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    @Column(
            length = 50
    )
    private String email;

    @NotNull
    private int age;

    @Column(
            updatable = false
    )
    private Date creationDate;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private StudentProfile studentProfile;

}
