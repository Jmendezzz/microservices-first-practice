package org.mendez.springcloud.msvc.courses.services;

import org.mendez.springcloud.msvc.courses.entities.Course;
import org.mendez.springcloud.msvc.courses.models.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CourseService {
  List<Course> getAll();
  Optional<Course> getById(Long id);
  Course save(Course course);
  void delete(Long id);

  Optional<User> assignUser(Long courseId, User user);
  Optional<User> createUser(User user, Long courseId);
  Optional<User> unassignUser(Long courseId, User user);
}
