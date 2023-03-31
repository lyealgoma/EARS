package Views;

import Entities.UserEntity;

public class UserContext {
  private static UserEntity user;

  public static UserEntity getUser() {
    return user;
  }

  public static void setUser(UserEntity user) {
    UserContext.user = user;
  }
}
