package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAL.Database;
import Entities.FacultySearchEntity;
import Entities.UserEntity;
import Views.CreateFacultySearchView;

public class CreateFacultySearchService {
    public static List<UserEntity> getAllUsers() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users";
        Statement stmt = Database.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<UserEntity> userList = new ArrayList<UserEntity>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String role = rs.getString("role");
            
            userList.add(new UserEntity(id,firstName,lastName,email,role));
        }
        return userList;
    }


    public static void CreateFacultySearch() throws SQLException{
        Connection connection = Database.getConnection();
        String query = "INSERT INTO facultySearches (title, startDate, endDate) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        FacultySearchEntity facultySearch = new FacultySearchEntity(CreateFacultySearchView.titleField.getText(),
        java.sql.Date.valueOf(CreateFacultySearchView.startDate.getValue()),
        java.sql.Date.valueOf(CreateFacultySearchView.endDate.getValue()));

    }
}
