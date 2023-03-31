package Services;

import Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import DAL.Database;
import java.sql.*;

public class ListApplicationService {
    private Connection connection = Database.getConnection();
    /**
     * Mapper function to convert the applications db data to our application entity
     * class
     */
    public static ListApplicationEntity toEntity(ResultSet resultSet) {
      ListApplicationEntity listApplicationEntity = new ListApplicationEntity();
      try {
        listApplicationEntity.setId(resultSet.getInt("id"));
        listApplicationEntity.setApplicantName(resultSet.getString("applicantName"));
        listApplicationEntity.setSubmitDate(resultSet.getTimestamp("submitDate"));
        listApplicationEntity.setStatus(resultSet.getString("status"));
      } catch (SQLException sqlException) {
        // @todo: handle if a col is not selected from the query
      }
      return listApplicationEntity;
    }


    public ObservableList<ListApplicationEntity> listFacultySearchApplications(Integer facultySearchId) throws SQLException {
        String sql = "";
        ObservableList<ListApplicationEntity> applications = FXCollections.observableArrayList();
        try {
        sql = "select id,CONCAT(JSON_UNQUOTE(json_extract(applicantProfile,'$.firstName')),' ',JSON_UNQUOTE(json_extract(applicantProfile,'$.lastName'))) as applicantName, submitDate,status from applications where facultySearchId = " + facultySearchId;
        ResultSet resultSet = Database.getConnection().createStatement().executeQuery(sql);

        // in programming, iterator => mem pointer

        // return applications;

            // transform the result set to our user data in Java
            // user object: id, email, firstName, lastName
            // abstract the tranforming logic into a furncito
            while (resultSet.next()) {
            applications.add(ListApplicationService.toEntity(resultSet));
            }

            // Close the db connection
            Database.getConnection().close();
            System.out.println("DB is disconnected!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return applications;
  }
}
