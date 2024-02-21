package org.mendez.springcloud.msvc.users.services.imp;

import org.mendez.springcloud.msvc.users.entities.User;
import org.mendez.springcloud.msvc.users.exceptions.UserDuplicatedEmailException;
import org.mendez.springcloud.msvc.users.repositories.UserRepository;
import org.mendez.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public List<User> getAll() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  @Transactional
  public User save(User user) {
    if(getByEmail(user.getEmail()).isPresent()){
      throw new UserDuplicatedEmailException();
    }
    return userRepository.save(user);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public Optional<User> getByEmail(String email) {
    return userRepository.findUserByEmail(email);
  }
}
