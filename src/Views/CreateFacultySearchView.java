package Views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import Controllers.*;
import Entities.*;
import Services.CreateFacultySearchService;

public class CreateFacultySearchView extends Application {
    List<UserEntity> users = new ArrayList<>();
    List<String> userNames = new ArrayList<>();
    public static TextField titleField;
    public static DatePicker startDate;
    public static DatePicker endDate;
       

  @Override
  public void start(Stage ps) throws Exception {

    Pane root = new Pane();
    Scene scene = new Scene(root, 1280, 720, Color.WHITE);
    Stage stage = new Stage();

    
    Line line = new Line();
    line.setStartX(0);
    line.setStartY(0);
    line.setEndX(0);
    line.setEndY(1280);
    line.setStrokeWidth(270);
    line.setStroke(Color.rgb(169,169,169));

    
    Button viewUsersBtn = new Button("Users"); 
    viewUsersBtn.setFont(Font.font(null,FontWeight.BOLD,20));

    viewUsersBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");   
    viewUsersBtn.setOnMouseEntered(e -> {
      viewUsersBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");   
    });

    viewUsersBtn.setOnMouseExited(e -> {
    viewUsersBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");   
    });
    viewUsersBtn.setOnAction(e -> {
      viewUsersBtn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
    });
    

    viewUsersBtn.setOnAction((ActionEvent e) -> { 
      stage.close();
      try {
        new AdminUserDashBoardView().start(new Stage());
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });

    viewUsersBtn.setLayoutX(30);
    viewUsersBtn.setLayoutY(150);

    

    

    Button facultySearchBtn = new Button("Faculty search"); 
    facultySearchBtn.setFont(Font.font(null,FontWeight.BOLD,20));
    facultySearchBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");   
    /*facultySearchBtn.setOnMouseEntered(e -> {
      facultySearchBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");   
    });

    facultySearchBtn.setOnMouseExited(e -> {
      facultySearchBtn.setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");   
    });
    facultySearchBtn.setOnAction(e -> {
      facultySearchBtn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
    });*/
    

    facultySearchBtn.setOnAction((ActionEvent e) -> { 
      stage.close();
      try {

        // Set the root of the current scene to the new view
        new AdminDashBoardView().start(new Stage());
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });
    facultySearchBtn.setLayoutX(-13);
    facultySearchBtn.setLayoutY(260);



    
 
    Text pageNameTXT = new Text("Create Faculty Search");
    pageNameTXT.setFont(Font.font(null,FontWeight.BOLD,35));
    pageNameTXT.setLayoutX(455);
    pageNameTXT.setLayoutY(120);


    Label titleLabel = new Label("Title");
    titleLabel.setFont(Font.font(null,16));
    titleLabel.setLayoutX(400);
    titleLabel.setLayoutY(200);

    Label startLabel = new Label("Start");
    startLabel.setFont(Font.font(null,16));
    startLabel.setLayoutX(400);
    startLabel.setLayoutY(260);

    Label endLabel = new Label("End");
    endLabel.setFont(Font.font(null,16));
    endLabel.setLayoutX(400);
    endLabel.setLayoutY(320);

    Label committeeChairLabel = new Label("Committee chair");
    committeeChairLabel.setFont(Font.font(null,16));
    committeeChairLabel.setLayoutX(400);
    committeeChairLabel.setLayoutY(380);

    Label committeeMembersLabel = new Label("Committee members");
    committeeMembersLabel.setFont(Font.font(null,16));
    committeeMembersLabel.setLayoutX(400);
    committeeMembersLabel.setLayoutY(440);

    Label selectMembersLabel = new Label("Selected members");
    selectMembersLabel.setFont(Font.font(null,16));
    selectMembersLabel.setLayoutX(400);
    selectMembersLabel.setLayoutY(500);


    titleField = new TextField();
    titleField.setLayoutX(570);
    titleField.setLayoutY(200);


    startDate = new DatePicker ();
    startDate.setLayoutX(570);
    startDate.setLayoutY(260);
    //LocalDate startDate = datePicker.getValue();


    endDate = new DatePicker();
    endDate.setLayoutX(570);
    endDate.setLayoutY(320);



    users = CreateFacultySearchController.getAllUsers();

        for (UserEntity user : users) {
            userNames.add(user.getFirstName()+user.getLastName());
        }
    ObservableList<String> observableList = FXCollections.observableArrayList(userNames);
    ChoiceBox committeeChairCBOX = new ChoiceBox();
    committeeChairCBOX.setItems(observableList);
    committeeChairCBOX.setLayoutX(570);
    committeeChairCBOX.setLayoutY(380);

    
    ChoiceBox<String> committeeMembersCBOX = new ChoiceBox();
    committeeMembersCBOX.setItems(observableList);
    committeeMembersCBOX.setLayoutX(570);
    committeeMembersCBOX.setLayoutY(440);



    ListView<String> selectedmembersList = new ListView<>();
    selectedmembersList.setLayoutX(570);
    selectedmembersList.setLayoutY(500);
    selectedmembersList.setPrefHeight(120);


    Button addButton = new Button("Add");
    addButton.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");
    addButton.setPrefWidth(150);
    addButton.setPrefHeight(30);
    addButton.setLayoutX(850);
    addButton.setLayoutY(440);
    addButton.setOnAction(e -> {
      String selectedMember = committeeMembersCBOX.getValue();
      if (selectedMember != null) {
        selectedmembersList.getItems().add(selectedMember);
      }
    });

   /*  Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            int selectedIndex = selectedmembersList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
              selectedmembersList.getItems().remove(selectedIndex);
            }
        });*/

    
    Button createButton = new Button("Create");
    createButton.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");
    createButton.setPrefWidth(150);
    createButton.setPrefHeight(35);
    createButton.setLayoutX(550);
    createButton.setLayoutY(650);
    createButton.setOnAction(e -> {

    });



    root.getChildren().add(line);
    root.getChildren().add(viewUsersBtn);
    root.getChildren().add(facultySearchBtn);
    root.getChildren().add(pageNameTXT);
    root.getChildren().add(titleLabel);
    root.getChildren().add(startLabel);
    root.getChildren().add(endLabel);
    root.getChildren().add(committeeChairLabel);
    root.getChildren().add(committeeMembersLabel);
    root.getChildren().add(selectMembersLabel);


    root.getChildren().add(titleField);
    root.getChildren().add(startDate);
    root.getChildren().add(endDate);
    root.getChildren().add(committeeChairCBOX);
    root.getChildren().add(committeeMembersCBOX);
    root.getChildren().add(selectedmembersList);



    root.getChildren().add(addButton);
    root.getChildren().add(createButton);


    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    stage.requestFocus();
  }
}

  
