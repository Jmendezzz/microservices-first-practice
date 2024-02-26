package org.mendez.springcloud.msvc.courses.services.imp;

import org.mendez.springcloud.msvc.courses.clients.UserRestClient;
import org.mendez.springcloud.msvc.courses.entities.Course;
import org.mendez.springcloud.msvc.courses.entities.CourseUser;
import org.mendez.springcloud.msvc.courses.models.User;
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

  @Autowired
  private UserRestClient userRestClient;
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

  @Override
  @Transactional
  public Optional<User> assignUser(Long courseId, User user) {
    Optional<Course> courseOptional = courseRepository.findById(courseId);
    if(courseOptional.isPresent()){
      User userMsvc = userRestClient.getUser(user.getId());

      Course course = courseOptional.get();
      CourseUser courseUser = new CourseUser();
      courseUser.setUserId(userMsvc.getId());

      course.addCourseUser(courseUser);
      courseRepository.save(course);

      return Optional.of(userMsvc);
    }
    return Optional.empty();
  }

  @Override
  @Transactional
  public Optional<User> createUser(User user, Long courseId) {
    Optional<Course> courseOptional = courseRepository.findById(courseId);
    if(courseOptional.isPresent()){
      User userMsvc = userRestClient.createUser(user);

      Course course = courseOptional.get();
      CourseUser courseUser = new CourseUser();
      courseUser.setUserId(userMsvc.getId());

      course.addCourseUser(courseUser);
      courseRepository.save(course);

      return Optional.of(userMsvc);
    }
    return Optional.empty();
  }

  @Override
  @Transactional
  public Optional<User> unassignUser(Long courseId, User user) {

    Optional<Course> courseOptional = courseRepository.findById(courseId);
    if(courseOptional.isPresent()){
      User userMsvc = userRestClient.getUser(user.getId());

      Course course = courseOptional.get();
      CourseUser courseUser = new CourseUser();
      courseUser.setUserId(userMsvc.getId());

      course.removeCourseUser(courseUser);
      courseRepository.save(course);

      return Optional.of(userMsvc);
    }
    return Optional.empty();
  }
}
