package org.mendez.springcloud.msvc.courses.clients;

import org.mendez.springcloud.msvc.courses.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-users", url = "localhost:8001")
public interface UserRestClient {
  @GetMapping("/users/{id}")
  User getUser(@PathVariable Long id);

  @PostMapping("/users")
  User createUser(@RequestBody User user);


}
