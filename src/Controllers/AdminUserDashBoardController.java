package Controllers;

import java.sql.SQLException;
import java.util.List;

import Entities.UserEntity;
import Services.AdminUserDashBoardService;

public class AdminUserDashBoardController {
    public static List<UserEntity> getAllUsers() throws ClassNotFoundException, SQLException{
        return AdminUserDashBoardService.getAllUsers();
    }


    public static void updateUserData(UserEntity user){
        AdminUserDashBoardService.updateUserData(user);
    }
}
