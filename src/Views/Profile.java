package Views;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Profile extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane pane2 = new GridPane();
		Label title = new Label("XXX's Profile");
		title.setFont(Font.font(null, FontWeight.BOLD, 35));
		pane2.add(title, 0, 0);
		GridPane.setHalignment(title, HPos.LEFT);

		GridPane pane = new GridPane();

		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setVgap(2);
		pane.setHgap(150);

		Image camera = new Image("https://cdn-icons-png.flaticon.com/512/3566/3566345.png");
		ImageView cameraView = new ImageView(camera);
		cameraView.setFitHeight(50);
		cameraView.setFitWidth(50);

		BorderPane pane1 = new BorderPane();
		pane1.setCenter(cameraView);

		pane.add(pane1, 1, 0, 2, 1);

		Label label = new Label("First Name");
		pane.add(label, 1, 1);
		pane.add(new TextField(), 1, 2);

		Label label1 = new Label("Last Name");
		pane.add(label1, 2, 1);
		pane.add(new TextField(), 2, 2);

		Label label2 = new Label("Email");
		pane.add(label2, 1, 4);
		pane.add(new TextField(), 1, 5, 2, 1);

		Label label3 = new Label("Contact Number");
		pane.add(label3, 1, 7);
		pane.add(new TextField(), 1, 8, 2, 1);

		Label label4 = new Label("Address");
		pane.add(label4, 1, 10);
		pane.add(new TextField(), 1, 11, 2, 1);

		Label label5 = new Label("City");
		pane.add(label5, 1, 13);
		pane.add(new TextField(), 1, 14);

		Label label6 = new Label("Province");
		pane.add(label6, 2, 13);
		pane.add(new TextField(), 2, 14);

		Label label7 = new Label("Zip Code");
		pane.add(label7, 1, 16);
		pane.add(new TextField(), 1, 17);

		Label label8 = new Label("Country");
		pane.add(label8, 2, 16);
		pane.add(new TextField(), 2, 17);

		Label label9 = new Label("Password");
		pane.add(label9, 1, 19);
		pane.add(new PasswordField(), 1, 20);

		Label label10 = new Label("Role");
		pane.add(label10, 2, 19);
		pane.add(new TextField(), 2, 20);

		Button save = new Button("   Save   ");
		save.setFont(Font.font(17));
		save.setStyle("-fx-background-color: #0574B2");
		save.setTextFill(Color.WHITE);

		pane.add(save, 1, 31);

		pane2.add(pane, 100, 1);
		GridPane.setHalignment(pane, HPos.CENTER);

		// action
		save.setOnAction(e -> {

		});

		Scene scene = new Scene(pane2, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Profile");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
