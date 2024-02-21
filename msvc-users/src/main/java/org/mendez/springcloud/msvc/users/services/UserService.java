package org.mendez.springcloud.msvc.users.services;

import org.mendez.springcloud.msvc.users.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getAll();
  Optional<User> getById(Long id);
  User save(User user);
  void delete(Long id);
  Optional<User> getByEmail(String email);

}
