package Views;

import Entities.*;
import javafx.application.Application;
import javafx.stage.Stage;
import Controllers.*;

public class ApplicationProcessView extends Application {
  ApplicationController applicationController = new ApplicationController();

  @Override
  public void start(Stage arg0) throws Exception {
    // call controller
    Integer id = 1;
    ApplicationEntity application = applicationController.getApplication(id);
    // render an application

    // render button for accept/reject
    //
  }

  public void onClickAcceptButton() {
    //
    ApplicationController applicationController = new ApplicationController();
    ApplicationEntity acceptedApplication = applicationController.acceptApplication(1);
    // refresh the application data in the view;
    // pane.set

  }
}
