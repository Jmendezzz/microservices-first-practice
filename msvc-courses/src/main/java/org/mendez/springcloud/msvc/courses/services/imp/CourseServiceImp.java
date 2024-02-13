package org.mendez.springcloud.msvc.courses.services.imp;

import org.mendez.springcloud.msvc.courses.entities.Course;
import org.mendez.springcloud.msvc.courses.repositories.CourseRepository;
import org.mendez.springcloud.msvc.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {
  @Autowired
  private CourseRepository courseRepository;
  @Override
  @Transactional(readOnly = true)
  public List<Course> getAll() {
    return (List<Course>) courseRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Course> getById(Long id) {
    return courseRepository.findById(id);
  }

  @Override
  @Transactional
  public Course save(Course course) {
    return courseRepository.save(course);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    courseRepository.deleteById(id);
  }
}
