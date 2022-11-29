package com.cydeo.controller;

import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;

    public SchoolController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeachers(){
        return teacherService.findAll();
    }

}
