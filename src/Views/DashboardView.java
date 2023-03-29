package Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

import Controllers.*;
import Entities.*;


public class DashboardView extends Application {

  private FacultySearchController facultySearchController = new FacultySearchController();

  @Override
  public void start(Stage primaryStage) {
    // TODO Auto-generated method stub

    Integer userId = 1;
    ArrayList<FacultySearchEntity> list = facultySearchController.listAllFacultySearch(userId);

    // render list of faculty searches
   
  
      BorderPane pane = new BorderPane();
  
      pane.setPadding(new Insets(50, 100, 100, 200));
  
      VBox vBox = new VBox();
      vBox.setPadding(new Insets(10, 5, 5, 300));
  
      Label label1 = new Label("Dashboard");
      label1.setFont(Font.font(40));
  
      Label label2 = new Label("");
      
      label2.setText(LoginView.Dashboardemail);
  
      label2.setFont(Font.font(20));
  
      vBox.getChildren().addAll(label1, label2);
      pane.setTop(vBox);
  
      BorderPane.setAlignment(vBox, Pos.CENTER);
  
      Label label = new Label("");
      //label.setText();
      label.setFont(Font.font(20));
      label.setLayoutX(1068);
      label.setLayoutY(50);
      
      //action
      label.setOnMouseClicked(e-> {
        new Profile().start(new Stage());
      }
      );
  
      Image camera = new Image("https://cdn-icons-png.flaticon.com/512/3566/3566345.png");
      ImageView cameraView = new ImageView(camera);
      cameraView.setFitHeight(30);
      cameraView.setFitWidth(30);
      cameraView.setX(1200);
      cameraView.setY(50);
  
      Label label3 = new Label("Faculty searches");
      label3.setFont(Font.font(20));
      label3.setLayoutX(175);
      label3.setLayoutY(200);
  
      Rectangle rect = new Rectangle();
      rect.setWidth(500);
      rect.setHeight(400);
      rect.setArcHeight(20);
      rect.setArcWidth(20);
      rect.setFill(Color.LIGHTGREY);
      rect.setX(375);
      rect.setY(200);
      Group root = new Group(rect);
  
      //Hyperlink link1 = new Hyperlink("Software Engineering");
      //Hyperlink link2 = new Hyperlink("Math");
      
      Label link1 = new Label("id: ");
      link1.setTextFill(Color.web("0574B2"));
      link1.setLayoutX(400);
      link1.setLayoutY(225);

      TextField idfield = new TextField();
      idfield.setLayoutX(500);
      idfield.setLayoutY(225);
      idfield.setEditable(false);

      Label link2 = new Label("Title: ");
      link2.setTextFill(Color.web("0574B2"));
      link2.setLayoutX(400);
      link2.setLayoutY(275);

      TextField titlefield = new TextField();
      titlefield.setLayoutX(500);
      titlefield.setLayoutY(275);
      titlefield.setEditable(false);
  
      Label link3 = new Label("StartDate: ");
      link3.setTextFill(Color.web("0574B2"));
      link3.setLayoutX(400);
      link3.setLayoutY(325);

      TextField startdatefield = new TextField();
      startdatefield.setLayoutX(500);
      startdatefield.setLayoutY(325);
      startdatefield.setEditable(false);

      Label link4 = new Label("EndDate: ");
      link4.setTextFill(Color.web("0574B2"));
      link4.setLayoutX(400);
      link4.setLayoutY(375);

      TextField enddatefield = new TextField();
      enddatefield.setLayoutX(500);
      enddatefield.setLayoutY(375);
      enddatefield.setEditable(false);

      Label link5 = new Label("Status: ");
      link5.setTextFill(Color.web("0574B2"));
      link5.setLayoutX(400);
      link5.setLayoutY(425);

      TextField statusfield = new TextField();
      statusfield.setLayoutX(500);
      statusfield.setLayoutY(425);
      statusfield.setEditable(false);



      root.getChildren().addAll(cameraView, link1, idfield, link2, titlefield, startdatefield,enddatefield,statusfield, link3,link4,link5, label, label3, pane);
  
      Scene scene = new Scene(root, 1280, 720);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Profile");
      primaryStage.show();
    }
  
    public static void main(String[] args) {
      launch(args);
    }
  }  
