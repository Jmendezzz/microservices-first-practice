package org.mendez.springcloud.msvc.courses.repositories;

import org.mendez.springcloud.msvc.courses.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
