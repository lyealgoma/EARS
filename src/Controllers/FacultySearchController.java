package Controllers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.*;
import Services.*;;

public class FacultySearchController {
  // for regular user
  public ArrayList<FacultySearchEntity> listUserAllFacultySearch(Integer userId) {

    FacultySearchService service = new FacultySearchService();
    return service.listUserAllFacultySearch(userId);
  }

  public ArrayList<FacultySearchEntity> listAllFacultySearches() {

    FacultySearchService service = new FacultySearchService();
    return service.listAllFacultySearch();
  }

  public static void createFacultySearch(FacultySearchEntity facultySearchEntity) throws SQLException {
    
  
      FacultySearchService.createFacultySearch(facultySearchEntity);
 
}

  public static void createFacultySearch(String text, Date valueOf, Date valueOf2) {
  }
}