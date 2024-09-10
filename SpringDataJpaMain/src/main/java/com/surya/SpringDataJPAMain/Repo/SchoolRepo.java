package com.surya.SpringDataJPAMain.Repo;

import com.surya.SpringDataJPAMain.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Long> {
}
