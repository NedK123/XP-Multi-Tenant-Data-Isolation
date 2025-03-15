package org.example.xpmultitenantdataisolation.persistence;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {
  Optional<UserEntity> findByTenantIdAndId(String tenantId, int userId);
}
