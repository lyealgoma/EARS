package Views;

import Controllers.DashboardController;
import Controllers.UserController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginView extends Application {

  public static String Dashboardemail;
  public static String fname1;
  public static String lname1;


@Override
  public void start(Stage primaryStage) {
    // enter pasword, email
    // sent to the controller
    // we verify the password, email
    // if good then we allow them to enter the dash
    // if not return error
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20, 20, 20, 20));
    pane.setVgap(50);
    pane.setHgap(50);

    Label label = new Label("Login- EARS");
    label.setFont(Font.font(null, FontWeight.BOLD, 60));
    label.setTextFill(Color.web("0574B2"));
    pane.add(label, 0, 0, 2, 1);
    GridPane.setHalignment(label, HPos.CENTER);

    Label label1 = new Label("User ID");
    label1.setFont(Font.font(null, FontWeight.BOLD, 30));
    pane.add(label1, 0, 2);
    TextField userNameField = new TextField();
    pane.add(userNameField, 1, 2);

    Label label2 = new Label("Password");
    label2.setFont(Font.font(null, FontWeight.BOLD, 30));
    pane.add(label2, 0, 3);
    PasswordField passwordField = new PasswordField();
    pane.add(passwordField, 1, 3);

    Button login = new Button("Login");
    login.setStyle("-fx-background-color: #0574B2");
    login.setTextFill(Color.WHITE);

    Button cancel = new Button("Cancel");
    cancel.setStyle("-fx-background-color: #B6BBBE");
    cancel.setTextFill(Color.WHITE);

    pane.add(login, 1, 4);
    pane.add(cancel, 1, 4);
    GridPane.setHalignment(login, HPos.LEFT);
    GridPane.setHalignment(cancel, HPos.CENTER);

    Label label3 = new Label("Don’t have an account? Contact IT Department.");
    label3.setFont(Font.font(20));
    label3.setTextFill(Color.web("0574B2"));
    pane.add(label3, 0, 6, 2, 1);
    GridPane.setHalignment(label3, HPos.CENTER);

    Label label5 = new Label("Algoma University");
    label5.setFont(Font.font(20));
    label5.setTextFill(Color.BLACK);
    pane.add(label5, 0, 8, 2, 1);
    GridPane.setHalignment(label5, HPos.CENTER);

    // event when user click login
    login.setOnAction(e -> {
      String email = userNameField.getText();
      String password = passwordField.getText();

      // sent to the user controller
     // String fname = UserController.fname(email);
      //String lname = UserController.lname(email);
      //fname1 = fname;
      //lname1 = lname;
      Boolean isAuthenticated = UserController.authenticate(email, password);
      if (isAuthenticated == true) {
        // also need to check the user role to direct to different page
        // redirect user to dashboard
        
        Dashboardemail = email;
       
      
        new DashboardView().start(new Stage());

       
        
        
     
        
      } 

      if (isAuthenticated == false){
        System.out.println("username/password incorrect");
      }
    });

    cancel.setOnAction(e -> {
      new LoginView().start(new Stage());
    });

    Scene scene = new Scene(pane, 1280, 720);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Employment Application Review System");
    primaryStage.show();
  }

  

  public static void main(String[] args) {
    launch(args);
  }
}