package org.example.xpmultitenantdataisolation.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.xpmultitenantdataisolation.core.User;
import org.example.xpmultitenantdataisolation.core.UserProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
  private UserProvider provider;

  @GetMapping("/user/{userId}")
  public ResponseEntity<User> fetchUser(@PathVariable("userId") String userId) {
    log.info("Fetch user with id={}", userId);
    return ResponseEntity.ok(provider.fetchUser(Integer.parseInt(userId)));
  }

  @GetMapping("/tenant/{tenantId}/user/{userId}")
  public ResponseEntity<User> fetchUser(
      @PathVariable("tenantId") String tenantId, @PathVariable("userId") String userId) {
    log.info("Fetch user with tenant_id={} and id={}", tenantId, userId);
    return ResponseEntity.ok(provider.fetchUser(tenantId, Integer.parseInt(userId)));
  }
}
