package Controllers;

import Entities.ApplicationEntity;
import Services.*;

public class ApplicationController {
  public ApplicationEntity getApplication(Integer applicationId) {
    return new ApplicationEntity();
  }

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // call the accept application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity acceptedApplication = applicationService.acceptApplication(applicationId);
    return acceptedApplication;
  }
}
