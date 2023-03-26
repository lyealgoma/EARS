package Services;

import Entities.*;
import DAL.Database;
import java.sql.*;

public class ApplicationService {
  private Connection connection = Database.getConnection();

    /**
   * Mapper function to convert the user db data to our user entity class
   */
  public static ApplicationEntity toEntity(ResultSet resultSet) {
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      applicationEntity.setId(resultSet.getInt("id"));
      applicationEntity.setStatus(resultSet.getString("status"));
      applicationEntity.setFirstName(resultSet.getString("firstName"));
      applicationEntity.setLastName(resultSet.getString("lastName"));
      applicationEntity.setPhone(resultSet.getString("phone"));
      applicationEntity.setEmail(resultSet.getString("email"));
      applicationEntity.setAddress(resultSet.getString("address"));
      applicationEntity.setCity(resultSet.getString("city"));
      applicationEntity.setProvince(resultSet.getString("province"));
      applicationEntity.setPosition(resultSet.getString("position"));
      applicationEntity.setDepartment(resultSet.getString("department"));
      applicationEntity.setExperience1(resultSet.getString("experience1"));
      applicationEntity.setExperience2(resultSet.getString("experience2"));
      applicationEntity.setEducation1(resultSet.getString("education1"));
      applicationEntity.setEducation2(resultSet.getString("education2"));
    } catch (SQLException sqlException) {
      // @todo: handle if a col is not selected from the query
    }
    return applicationEntity;
  }
  // Get an application
  public ApplicationEntity getApplicationById(Integer id) {
    String sql = "";
    ApplicationEntity applicationEntity = null;
    try {
      sql = "select id,status,JSON_UNQUOTE(json_extract(applicantProfile,'$.firstName')) as firstName," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.lastName')) as lastName," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.phone')) as phone," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.email')) as email," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.address')) as address," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.city')) as city," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.province')) as province," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.position')) as position," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.department')) as department," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.experience1')) as experience1," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.experience2')) as experience2," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.education1')) as education1," +
                      "JSON_UNQUOTE(json_extract(applicantProfile,'$.education2')) as education2 " +
              "from applications where id=" + id;
      ResultSet resultSet = Database.getConnection().createStatement().executeQuery(sql);

      // in programming, iterator => mem pointer

      if (resultSet.next()) {
        // transform the result set to our user data in Java
        // user object: id, email, firstName, lastName
        // abstract the tranforming logic into a furncito
        applicationEntity = ApplicationService.toEntity(resultSet);
      } else {
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return applicationEntity;
  }

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // send noty to applicants
    // send noty to head of department
    // ....
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      ResultSet updatedResult = connection
          .prepareStatement("update applications set status = 'accept' where id = " + applicationId).executeQuery();
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of acceptApplication method

  public ApplicationEntity rejectApplication(Integer applicationId) {
    // send noty to applicants
    // send noty to head of department
    // ....
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      ResultSet updatedResult = connection
          .prepareStatement("update applications set status = 'reject' where id = " + applicationId).executeQuery();
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of rejectApplication method

}
