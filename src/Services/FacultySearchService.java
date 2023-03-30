
package Services;

import java.util.ArrayList;
import Entities.*;
import DAL.Database;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Entities.FacultySearchEntity;
import Entities.MemberEntity;
import Entities.UserEntity;
import Views.CreateFacultySearchView;

public class FacultySearchService {
  // pool
  private Connection connection = Database.getConnection();

  public static FacultySearchEntity toEntity(ResultSet resultSet) {
    FacultySearchEntity facultySearchEntity = new FacultySearchEntity();
    try {
      facultySearchEntity.setTitle(resultSet.getString("title"));
      facultySearchEntity.setId(resultSet.getInt("id"));
      facultySearchEntity.setStatus(resultSet.getString("status"));
    } catch (SQLException sqlException) {
      // @todo: handle if a col is not selected from the query
    }
    return facultySearchEntity;
  }

  public ArrayList<FacultySearchEntity> listUserAllFacultySearch(Integer userId) {
    ArrayList<FacultySearchEntity> list = new ArrayList<>();
    try {
      ResultSet resultSet = this.connection.prepareStatement(
          "SELECT title FROM facultySearches f JOIN members ON facultySearchId = f.id JOIN users ON members.userId = users.id WHERE users.id="
              + userId)
          .executeQuery();

      // iterator
      for (int i = 0; resultSet.next(); i++) {
        list.add(FacultySearchService.toEntity(resultSet));

      }

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return list;
  }

  public ArrayList<FacultySearchEntity> listAllFacultySearch() {
    ArrayList<FacultySearchEntity> list = new ArrayList<>();
    try {
      ResultSet resultSet = this.connection.prepareStatement(
          "SELECT title, startDate, endDate, status FROM facultySearches")
          .executeQuery();

      // iterator
      for (int i = 0; resultSet.next(); i++) {
        list.add(FacultySearchService.toEntity(resultSet));

      }

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return list;
  }

  // this service is only for handling faculty search
  public static FacultySearchEntity createFacultySearch(String title, Date starDate, Date endDate) throws SQLException {
    Connection connection = Database.getConnection();
    String query = "INSERT INTO facultySearches (title, startDate, endDate) VALUES (?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, title);
    statement.setDate(2, starDate);
    statement.setDate(3, endDate);

    ResultSet resultSet = statement.executeQuery();
    resultSet.next();

    return FacultySearchService.toEntity(resultSet);
  }

  public static void assignUserToFacultySearch(Integer userId, Integer facultySearchId) throws SQLException {
    // under the system, create member
    // create a member to link user with search

    Connection connection = Database.getConnection();
    String query = "INSERT INTO members (userId, facultySearchId) VALUES (" + userId + ", " + facultySearchId + ")";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.executeQuery();
  }
}
