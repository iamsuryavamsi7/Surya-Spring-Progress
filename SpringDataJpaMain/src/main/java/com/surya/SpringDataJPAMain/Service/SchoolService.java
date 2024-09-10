package com.surya.SpringDataJPAMain.Service;

import com.surya.SpringDataJPAMain.DTO.SchoolDTO;
import com.surya.SpringDataJPAMain.Entity.School;
import com.surya.SpringDataJPAMain.Repo.SchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;

    public SchoolDTO saveSchool(SchoolDTO request) {

        School school = new School();

        school.setName(request.getName());

        School savedSchool = schoolRepo.save(school);

        return new SchoolDTO(
                savedSchool.getName()
        );

    }

    public SchoolDTO toSchoolDTO(School request){

        return new SchoolDTO(
                request.getName()
        );

    }

    public List<SchoolDTO> fetchAllSchools() {

//        List<School> fetchedSchools = schoolRepo.findAll();
//
//        List<SchoolDTO> schools = new ArrayList<>();
//
//        for ( School school: fetchedSchools ) {
//
//            SchoolDTO createdSchool = new SchoolDTO(
//                    school.getName()
//            );
//
//            schools.add(createdSchool);
//
//        }
//
//        return schools;

        return schoolRepo.findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());

    }

}
