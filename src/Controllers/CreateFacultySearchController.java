package Controllers;

import java.sql.SQLException;
import java.util.List;

import Entities.UserEntity;
import Services.CreateFacultySearchService;

public class CreateFacultySearchController {
    public static List<UserEntity> getAllUsers() throws ClassNotFoundException, SQLException{
        return CreateFacultySearchService.getAllUsers();
    }
}
