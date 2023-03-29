package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAL.Database;
import Entities.*;

public class UserService {
  /**
   * Mapper function to convert the user db data to our user entity class
   */
  public static UserEntity toEntity(ResultSet resultSet) {
    UserEntity userEntity = new UserEntity();
    try {
      userEntity.setEmail(resultSet.getString("email"));
      userEntity.setPassword(resultSet.getString("password"));
      userEntity.setFirstName(resultSet.getString("firstName"));
      userEntity.setLastName(resultSet.getString("lastName"));
    } catch (SQLException sqlException) {
      // @todo: handle if a col is not selected from the query
    }
    return userEntity;
  }

  public static UserEntity getUserById(Integer id) {
    UserEntity userEntity = null;
    try {
      ResultSet resultSet = Database.getConnection().prepareStatement("SELECT * FROM users WHERE id=" + id)
          .executeQuery();

      // in programming, iterator => mem pointer

      if (resultSet.next()) {
        // transform the result set to our user data in Java
        // user object: id, email, firstName, lastName
        // abstract the tranforming logic into a furncito
        userEntity = UserService.toEntity(resultSet);
      } else {
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userEntity;
  }

  public static UserEntity getUserByEmail(String email) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();
      ResultSet resultSet = connection
          .prepareStatement("SELECT email, password FROM users WHERE email ='" + email + "'")
          .executeQuery();

      if (resultSet.next()) {
        // convert the user db result set to our user entity pass
        userEntity = UserService.toEntity(resultSet);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userEntity;

  }

  public static UserEntity getUserByEmail1(String email) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();
      ResultSet resultSet = connection
          .prepareStatement("SELECT firstName FROM users WHERE email ='" + email + "'")
          .executeQuery();

      if (resultSet.next()) {
        // convert the user db result set to our user entity pass
        userEntity = UserService.toEntity(resultSet);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userEntity;

  }

  public static UserEntity getUserByEmail2(String email) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();
      ResultSet resultSet = connection
          .prepareStatement("SELECT lastName FROM users WHERE email ='" + email + "'")
          .executeQuery();

      if (resultSet.next()) {
        // convert the user db result set to our user entity pass
        userEntity = UserService.toEntity(resultSet);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userEntity;

  }

  // public static boolean verify(String email, String password) {

  // }

}