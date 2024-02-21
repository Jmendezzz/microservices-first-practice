package org.mendez.springcloud.msvc.users.repositories;

import org.mendez.springcloud.msvc.users.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
  Optional<User> findUserByEmail(String email);
}
