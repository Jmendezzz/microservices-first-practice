package org.mendez.springcloud.msvc.courses.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.mendez.springcloud.msvc.courses.models.User;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id")
  private List<CourseUser> courseUsers;

  @Transient
  private List<User> users;

  public void addCourseUser(CourseUser courseUser){
    courseUsers.add(courseUser);
  }

  public void removeCourseUser(CourseUser courseUser){
    courseUsers.remove(courseUser);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
