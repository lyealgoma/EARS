package Views;

import javafx.scene.control.TableColumn;
import Controllers.ApplicationController;
import Entities.ApplicationEntity;
import Entities.FacultySearchEntity;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewFacultySearchView extends Application {
  private ApplicationController applicationController = new ApplicationController();
  private FacultySearchEntity facultySearch = new FacultySearchEntity();
  public static Label facultySearchLabel;

  public ViewFacultySearchView() {

  }

  public ViewFacultySearchView(FacultySearchEntity facultySearch) {
    this.facultySearch = facultySearch;
  }

  @Override
  public void start(Stage arg0) throws Exception {
    Pane root = new Pane();
    Scene scene = new Scene(root, 1280, 720, Color.WHITE);
    Stage stage = new Stage();

    //facultySearchLabel = new Label("Faculty Search: Software Engineering Instructor");
    facultySearchLabel.setFont(Font.font(null, FontWeight.BOLD, 26));
    facultySearchLabel.setLayoutX(20);
    facultySearchLabel.setLayoutY(20);

    Button dashboardBtn = new Button("Dashboard");
    dashboardBtn.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");
    dashboardBtn.setPrefWidth(150);
    dashboardBtn.setPrefHeight(35);
    dashboardBtn.setLayoutX(1000);
    dashboardBtn.setLayoutY(70);
    dashboardBtn.setOnAction((ActionEvent e) -> {
      stage.close();
      try {

        // Set the root of the current scene to the new view
        new AdminDashBoardView().start(new Stage());
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });

    TableView table = new TableView<ApplicationEntity>();
    table.setEditable(false);

    TableColumn<ApplicationEntity, String> applicantNameColumn = new TableColumn<ApplicationEntity, String>(
        "Applicant Name");
    TableColumn<ApplicationEntity, String> submitDateColumn = new TableColumn<ApplicationEntity, String>("Submit Date");
    TableColumn<ApplicationEntity, String> statusColumn = new TableColumn<ApplicationEntity, String>("Status");

    table.getColumns().addAll(applicantNameColumn, submitDateColumn, statusColumn);
    table.setPrefSize(600, 370);
    table.setLayoutX(350);
    table.setLayoutY(160);

    // create table row with a for loop
    // how to to pass id date from a vew to another
    System.out.println(facultySearch.getId());
    applicationController.listFacultySearchApplications(facultySearch.getId());

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    root.getChildren().add(facultySearchLabel);
    root.getChildren().add(dashboardBtn);
    root.getChildren().add(table);

    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    stage.requestFocus();

  }

}