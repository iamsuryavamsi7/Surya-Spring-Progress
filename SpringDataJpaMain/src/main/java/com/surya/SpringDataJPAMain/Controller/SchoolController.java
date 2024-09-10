package com.surya.SpringDataJPAMain.Controller;

import com.surya.SpringDataJPAMain.DTO.SchoolDTO;
import com.surya.SpringDataJPAMain.Entity.School;
import com.surya.SpringDataJPAMain.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/schools")
    public ResponseEntity<SchoolDTO> saveSchool(
            @RequestBody SchoolDTO request
    ){

        SchoolDTO savedSchool = schoolService.saveSchool(request);

        return ResponseEntity.ok(savedSchool);

    }

    @GetMapping("/schools")
    public ResponseEntity<List<SchoolDTO>> fetchAllSchools(){

        List<SchoolDTO> savedSchool = schoolService.fetchAllSchools();

        return ResponseEntity.ok(savedSchool);

    }

}
