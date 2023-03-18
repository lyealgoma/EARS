package Views;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import Controllers.*;
import Entities.*;

public class DashboardView extends Application {
  private FacultySearchController facultySearchController = new FacultySearchController();

  @Override
  public void start(Stage arg0) throws Exception {
    // TODO Auto-generated method stub

    Integer userId = 1;
    ArrayList<FacultySearchEntity> list = facultySearchController.listAllFacultySearch(userId);

    // render list of faculty searches

  }

}
