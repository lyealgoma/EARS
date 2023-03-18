package Controllers;

import java.util.ArrayList;

import Entities.*;
import Services.*;;

public class FacultySearchController {
  public ArrayList<FacultySearchEntity> listAllFacultySearch(Integer userId) {

    FacultySearchService service = new FacultySearchService();
    return service.listAllFacultySearch(userId);
  }
}
