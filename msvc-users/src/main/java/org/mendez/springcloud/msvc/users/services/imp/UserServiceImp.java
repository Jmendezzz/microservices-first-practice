package org.mendez.springcloud.msvc.users.services.imp;

import jakarta.transaction.Transactional;
import org.mendez.springcloud.msvc.users.entities.User;
import org.mendez.springcloud.msvc.users.repositories.UserRepository;
import org.mendez.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public List<User> getAll() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  @Transactional
  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
