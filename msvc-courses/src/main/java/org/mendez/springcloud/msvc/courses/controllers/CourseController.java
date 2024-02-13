package org.mendez.springcloud.msvc.courses.controllers;

import org.mendez.springcloud.msvc.courses.entities.Course;
import org.mendez.springcloud.msvc.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
  @Autowired
  private CourseService courseService;

  @GetMapping
  public ResponseEntity<List<Course>> getAll(){
    return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id){
    Optional<Course> courseOptional = courseService.getById(id);

    return courseOptional
            .map(c-> new ResponseEntity<>(c,HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping
  public ResponseEntity<Course> save(@RequestBody Course course){
    return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Course course){

    Optional<Course> courseOptional = courseService.getById(course.getId());

    return courseOptional
            .map(c-> new ResponseEntity<>(courseService.save(c),HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
