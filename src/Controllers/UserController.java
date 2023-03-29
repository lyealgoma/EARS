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

  public static String fname(String email) {
    UserEntity userEntity = UserService.getUserByEmail(email);
    //just verifying
    System.out.println(userEntity.getFirstName()); 
    return userEntity.getFirstName();
  }

public static String lname(String email) {
  UserEntity userEntity = UserService.getUserByEmail(email);
    return userEntity.getLastName();
}

public static String role(String email) {
  UserEntity userEntity = UserService.getUserByEmail(email);
    return userEntity.getRole();
}
public static String pass(String email) {
  UserEntity userEntity = UserService.getUserByEmail(email);
  return userEntity.getPassword();
}



}
