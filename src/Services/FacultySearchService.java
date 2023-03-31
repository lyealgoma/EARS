
package Services;

import java.util.ArrayList;
import Entities.*;
import DAL.Database;
import java.sql.*;
import java.time.ZoneId;
import java.util.Date;

import Entities.FacultySearchEntity;


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
          "SELECT * FROM facultySearches")
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
  public static FacultySearchEntity createFacultySearch(FacultySearchEntity facultySearch) throws SQLException {
    Connection connection = Database.getConnection();
    String query = "INSERT INTO facultySearches (title, startDate, endDate) VALUES (?, ?, ?) RETURNING facultySearches.*";
    PreparedStatement statement = connection.prepareStatement(query);
    Date startDate = facultySearch.getStartDate();
    Date endDate = facultySearch.getEndDate();
    java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
    java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
    statement.setString(1, facultySearch.gettitle());
    statement.setDate(2, sqlStartDate);
    statement.setDate(3, sqlEndDate);

    ResultSet rs = statement.executeQuery();
    if (rs.next()) {
      System.out.println("A new facultySearch was inserted successfully!");
    }

    return FacultySearchService.toEntity(rs);
  }

  public static void assignUserToFacultySearch(Integer userId, Integer facultySearchId, String role)
      throws SQLException {
    // under the system, create member
    // create a member to link user with search

    Connection connection = Database.getConnection();
    String query = "INSERT INTO members (userId, facultySearchId, role) VALUES (" + userId + ", " + facultySearchId
        + ", " + role + ")";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.executeQuery();
  }
}
