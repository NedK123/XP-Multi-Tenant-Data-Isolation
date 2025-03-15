package org.example.xpmultitenantdataisolation.core;

public interface UserProvider {
  User fetchUser(int userId);

  User fetchUser(String tenantId, int userId);
}
