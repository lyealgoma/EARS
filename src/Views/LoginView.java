package Views;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import Controllers.*;
import Entities.*;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/** @todo: make sure to re-write this */
public class LoginView extends Application {
  private Label status;

  // This class is the main entry point
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage ps) {
    // Set up the pane geometry
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(20));
    pane.setVgap(10);
    pane.setHgap(10);

    // Set up title label
    Label title = new Label("Log In to the System");
    title.setFont(Font.font(16));
    pane.add(title, 0, 0, 2, 1);
    GridPane.setHalignment(title, HPos.CENTER);

    // Set up status label
    status = new Label();
    pane.add(status, 0, 1, 2, 1);
    GridPane.setHalignment(status, HPos.CENTER);

    // Create and add the username field
    pane.add(new Label("Enter UserID: "), 0, 2);
    TextField user = new TextField();
    pane.add(user, 1, 2);

    // Create and add the password field
    pane.add(new Label("Enter Password: "), 0, 3);
    PasswordField pass = new PasswordField();
    pane.add(pass, 1, 3);

    // Add the buttons
    Button login = new Button("Log On");
    Button exit = new Button("Exit");
    login.setMaxWidth(Double.MAX_VALUE);
    exit.setMaxWidth(Double.MAX_VALUE);
    GridPane.setHalignment(login, HPos.CENTER);
    GridPane.setHalignment(exit, HPos.CENTER);
    pane.add(exit, 0, 5);
    pane.add(login, 1, 5);

    // Log in button function
    login.setOnAction(e -> {

    });

    // Set up the Scene and Stage
    ps.setScene(new Scene(pane));
    ps.setTitle("Please Log On");
    ps.show();
    ps.requestFocus();
  }
}