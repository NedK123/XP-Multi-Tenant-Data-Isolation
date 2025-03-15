package org.example.xpmultitenantdataisolation.persistence;

import lombok.AllArgsConstructor;
import org.example.xpmultitenantdataisolation.core.User;
import org.example.xpmultitenantdataisolation.core.UserProvider;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbUserFetcher implements UserProvider {

  private final UserRepo repo;

  @Override
  public User fetchUser(int userId) {
    return repo.findById(userId).map(DbUserFetcher::mapUser).orElse(null);
  }

  @Override
  public User fetchUser(String tenantId, int userId) {
    return repo.findByTenantIdAndId(tenantId, userId).map(DbUserFetcher::mapUser).orElse(null);
  }

  private static User mapUser(UserEntity entity) {
    return User.builder()
        .id(String.valueOf(entity.getId()))
        .tenant_id(entity.getTenantId())
        .email(entity.getEmail())
        .username(entity.getUsername())
        .build();
  }
}
