package Controllers;

import Entities.*;
import Services.UserService;

public class UserController {

  public static UserEntity getUserById(Integer id) {
    return UserService.getUserById(id);
  }

  public static boolean authenticate(String email, String password) {
    // query user by email
    UserEntity userEntity = UserService.getUserByEmail(email);
    // comapre databaseSaved.password === userEnterpassword
    return userEntity.comparePassword(password);
  }

}
