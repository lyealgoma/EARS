package Services;
import Entities.*;
import DAL.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminUserDashBoardService {
  
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
    


    public static void updateUserData(UserEntity user) {
        try{
            PreparedStatement  statement  = Database.getConnection().prepareStatement("UPDATE users SET firstName = ?, lastName = ? WHERE id = ?");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getID());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User data updated successfully!");
            } else {
                System.out.println("Failed to update user data.");
            }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
}
