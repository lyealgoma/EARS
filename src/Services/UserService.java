package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.Database;
import Entities.*;
import javafx.scene.control.TextField;

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
      userEntity.setRole(resultSet.getString("role"));
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
          .prepareStatement(
              "SELECT email, password , firstName , lastName , role FROM users WHERE email ='" + email + "'")
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

  public static UserEntity setUserByEmail(String email, String firstname, String lastname, String pass, String role) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();

      ResultSet resultSet = connection.prepareStatement(
          "UPDATE users SET password = '" + pass + "'" + " role = '" + role + "'" + " firstName = '" + firstname + "'" +
              " lastName = '" + lastname + "'" + " WHERE email ='" + email + "'" + " RETURNING users.*")
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

  public static ArrayList<UserEntity> getAllUsers() throws SQLException, ClassNotFoundException {
    String query = "SELECT * FROM users";
    Statement stmt = Database.getConnection().createStatement();
    ResultSet rs = stmt.executeQuery(query);
    ArrayList<UserEntity> userList = new ArrayList<UserEntity>();
    while (rs.next()) {
      int id = rs.getInt("id");
      String firstName = rs.getString("firstName");
      String lastName = rs.getString("lastName");
      String email = rs.getString("email");
      String role = rs.getString("role");

      userList.add(new UserEntity(id, firstName, lastName, email, role));
    }
    return userList;
  }

}