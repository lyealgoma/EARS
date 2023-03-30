package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.*;
import Services.UserService;

public class UserController {

  public static ArrayList<UserEntity> getAllUsers() throws ClassNotFoundException, SQLException {
    return UserService.getAllUsers();
  }

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
