package Services;

import Entities.*;
import DAL.Database;
import java.sql.*;
import java.util.ArrayList;

public class ApplicationService {
  private Connection connection = Database.getConnection();

  /**
   * Mapper function to convert the applications db data to our application entity
   * class
   */
  public static ApplicationEntity toEntity(ResultSet resultSet) {
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      applicationEntity.setId(resultSet.getInt("id"));
      applicationEntity.setStatus(resultSet.getString("status"));
      applicationEntity.setApplicantName(resultSet.getString("applicantName"));
      applicationEntity.setSubmitDate(resultSet.getTimestamp("submitDate"));
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
      applicationEntity.setContent(resultSet.getString("content"));

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
      sql = "select t1.id,t1.status,JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.firstName')) as firstName," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.lastName')) as lastName," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.phone')) as phone," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.email')) as email," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.address')) as address," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.city')) as city," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.province')) as province," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.position')) as position," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.department')) as department," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.experience1')) as experience1," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.experience2')) as experience2," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.education1')) as education1," +
          "JSON_UNQUOTE(json_extract(t1.applicantProfile,'$.education2')) as education2, " +
          "t2.content " +
          "from applications t1 left join comments t2 " +
          "on (t1.id = t2.applicationId) and (t1.id=" + id + ")";
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
  } // End of getApplicationById method

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // send noty to applicants
    // send noty to head of department
    // ....
    String sql = "";
    Statement statement = null;
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      sql = "update applications set status = 'accept' where id =" + applicationId;
      statement = Database.getConnection().createStatement();
      statement.execute(sql);
      // ResultSet updatedResult =
      // Database.getConnection().createStatement().executeQuery(sql);
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
    String sql = "";
    Statement statement = null;
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      sql = "update applications set status = 'reject' where id =" + applicationId;
      statement = Database.getConnection().createStatement();
      statement.execute(sql);
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of rejectApplication method

  // Method of updating comment
  public ApplicationEntity updateComment(Integer applicationId, String comment) {
    String sql = "";
    Statement statement = null;
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      sql = "update comments set content = '" + comment + "' where applicationId =" + applicationId;
      statement = Database.getConnection().createStatement();
      statement.execute(sql);
      // ResultSet updatedResult =
      // Database.getConnection().createStatement().executeQuery(sql);
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of updateComment method

  // Method of saving new comment
  public ApplicationEntity saveComment(Integer applicationId, String comment, Integer userId) {
    String sql = "";
    Statement statement = null;
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      sql = "INSERT INTO comments (" +
          "  `applicationId`," +
          "  `content`," +
          "  `createdAt`," +
          "  `updatedAt`," +
          "  `author`	" +
          ")" +
          "VALUES (" + applicationId + ",'" + comment + "', DEFAULT, DEFAULT, " + userId + ")";
      ;
      statement = Database.getConnection().createStatement();
      statement.execute(sql);
      // ResultSet updatedResult =
      // Database.getConnection().createStatement().executeQuery(sql);
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of saveComment method

  // Method of deleting current comment
  public ApplicationEntity deleteComment(Integer applicationId) {
    String sql = "";
    Statement statement = null;
    ApplicationEntity applicationEntity = new ApplicationEntity();
    try {
      sql = "delete from comments where applicationId =" + applicationId;
      statement = Database.getConnection().createStatement();
      statement.execute(sql);
      // ResultSet updatedResult =
      // Database.getConnection().createStatement().executeQuery(sql);
      // @todo: convert the java sql object to our entity class
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return applicationEntity;
  } // End of saveComment method

  public ArrayList<ApplicationEntity> listFacultySearchApplications(Integer facultySearchId)
      throws SQLException {
    ResultSet resultSet = Database.getConnection()
        .prepareStatement("SELECT * FROM applications WHERE facultySearchId = " + facultySearchId).executeQuery();
    ArrayList<ApplicationEntity> applications = new ArrayList<ApplicationEntity>();
    while (resultSet.next()) {
      applications.add(ApplicationService.toEntity(resultSet));
    }
    return applications;
  }
}
