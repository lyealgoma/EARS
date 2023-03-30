package Controllers;

import java.sql.Date;
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

  public static FacultySearchEntity createFacultySearch(String title, Date starDate, Date endDate) {
    FacultySearchEntity facultySearchEntity = null;
    try {
      facultySearchEntity = FacultySearchService.createFacultySearch(title, starDate, endDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return facultySearchEntity;
  }
}
