package Services;

import java.util.ArrayList;
import Entities.*;
import DAL.Database;
import java.sql.*;;

public class FacultySearchService {
  // pool
  private Connection connection = Database.getConnection();

  public ArrayList<FacultySearchEntity> listAllFacultySearch(Integer userId) {
    ArrayList<FacultySearchEntity> list = new ArrayList<>();
    try {
      ResultSet resultSet = this.connection.prepareStatement("SELECT xxx from xxxx").executeQuery();
      // iterator
      for (int i = 0; !resultSet.next(); i++) {
        // todo
        list.add(null);
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
