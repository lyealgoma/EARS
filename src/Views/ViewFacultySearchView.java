package Views;

import javafx.scene.control.TableColumn;

import java.time.LocalDate;
import java.util.ArrayList;

import Controllers.ApplicationController;
import Controllers.ListApplicationController;
import Entities.ApplicationEntity;
import Entities.FacultySearchEntity;
import Entities.ListApplicationEntity;
import Services.ApplicationService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewFacultySearchView extends Application {
  private ListApplicationController listApplicationController = new ListApplicationController();
  private FacultySearchEntity facultySearch = new FacultySearchEntity();

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

    Label facultySearchLabel = new Label("Faculty Search: " + facultySearch.gettitle());
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

    // Create table view
    TableView table = new TableView<ApplicationEntity>();
    table.setEditable(false);

    // table columns
    TableColumn applicantNameColumn = new TableColumn("Applicant Name");
    TableColumn submitDateColumn = new TableColumn("Submit Date");
    TableColumn statusColumn = new TableColumn("Status");
    // Get values
    applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
    submitDateColumn.setCellValueFactory(new PropertyValueFactory<>("submitDate"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    // Insert values
    ObservableList<ListApplicationEntity> apps = FXCollections
        .observableArrayList(listApplicationController.listFacultySearchApplications(facultySearch.getId()));
    table.setItems(apps);

    applicantNameColumn.setCellValueFactory(new PropertyValueFactory<ApplicationEntity, String>("applicantName"));
    applicantNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    submitDateColumn.setCellValueFactory(new PropertyValueFactory<ApplicationEntity, LocalDate>("submitDate"));
    // System.out.println(
    // applicationController.listFacultySearchApplications(facultySearch.getId());

    statusColumn.setCellValueFactory(new PropertyValueFactory<ApplicationEntity, String>("status"));
    statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    table.getItems().addAll(applicationController.listFacultySearchApplications(facultySearch.getId()));

    table.getColumns().addAll(applicantNameColumn, submitDateColumn, statusColumn);
    table.setPrefSize(600, 370);
    table.setLayoutX(350);
    table.setLayoutY(160);

    // create table row with a for loop
    // how to to pass id date from a vew to another
    System.out.println(facultySearch.getId());
    // ObservableList<ApplicationEntity> applications = applicationController
    // .listFacultySearchApplications(1);

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    // table.setItems(FXCollections.observableList(applications));

    root.getChildren().add(facultySearchLabel);
    root.getChildren().add(dashboardBtn);
    root.getChildren().add(table);

    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    stage.requestFocus();

  }

}