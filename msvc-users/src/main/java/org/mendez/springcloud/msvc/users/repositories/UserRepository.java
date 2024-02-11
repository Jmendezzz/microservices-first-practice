package org.mendez.springcloud.msvc.users.repositories;

import org.mendez.springcloud.msvc.users.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
