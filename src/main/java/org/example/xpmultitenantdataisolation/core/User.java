package org.example.xpmultitenantdataisolation.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private String id;
  private String tenant_id;
  private String username;
  private String email;
}
