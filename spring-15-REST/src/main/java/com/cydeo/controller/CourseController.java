package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){

        return courseService.getCourses();
    }

    @GetMapping("{id}")
    private CourseDTO getCourseById(@PathVariable("id") Long id){

        return courseService.getCourseById(id);
    }

    @GetMapping("/category/{name}")
    private List<CourseDTO>  getCourseById(@PathVariable("name") String category){

        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO course){
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long id){
        courseService.deleteCourseById(id);
    }
}
