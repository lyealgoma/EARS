package Controllers;

import Entities.ApplicationEntity;
import Services.*;

public class ApplicationController {
  public ApplicationEntity getApplication(Integer applicationId) {
    // call the accept application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity gettedApplication = applicationService.getApplicationById(applicationId);
    return gettedApplication;
  } // End of getApplication method

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // call the accept application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity acceptedApplication = applicationService.acceptApplication(applicationId);
    return acceptedApplication;
  } // End of acceptApplication method

  public ApplicationEntity rejectApplication(Integer applicationId) {
    // call the reject application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity rejectedApplication = applicationService.rejectApplication(applicationId);
    return rejectedApplication;
  } // End of rejectApplication method

}
