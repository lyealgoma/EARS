package Services;

import Entities.*;
import DAL.Database;
import java.sql.*;

public class ApplicationService {
  private Connection connection = Database.connect();

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // send noty to applicants
    // send noty to head of department
    // ....
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      ResultSet updatedResult = connection
          .prepareStatement("update xxx set application.status = 'accept' where id = sxxxx").executeQuery();
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  }
}
