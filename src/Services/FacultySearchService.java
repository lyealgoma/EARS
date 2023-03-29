package Services;

import java.util.ArrayList;
import Entities.*;
import DAL.Database;
import java.sql.*;;


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

  public ArrayList<FacultySearchEntity> listAllFacultySearch(Integer userId) {
    ArrayList<FacultySearchEntity> list = new ArrayList<>();
    try {
      // we need to fetch a list of faculty searches assigned to the user
      // users
      // members
      // facultySearches

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

  // // view a faculty search
  // public getById(int searchId) {
  // dbConnection.constrcutSQL('SELECT xxx from xxxx where xxx.id = xxxx')
  // oneFacultySearch = dbConnection.excute
  // return oneFacultySearch
  // }
}
