package Interface.Window;

import Interface.Window.DB_function.DB_Checker;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.sql.Connection;


public class Conecting_Window extends Application {

	static Rectangle windowSize = new Rectangle(250,300);


	@Override
	public void start(Stage primaryStage){



        Button loginButton;
        Button createButton;

        HBox hb_dbName;
        TextField dbField;

        HBox hb_Username;
        TextField usernameField;

        HBox hb_Password;
        PasswordField passwordField;

	primaryStage.setTitle("DataBase_Manager");


	hb_Username = new HBox();
	usernameField=  new TextField();
	usernameField.setText("username");
	

	
	hb_Password = new HBox();
	passwordField = new PasswordField();
	passwordField.setText("passowrd");
	
	hb_Username.getChildren().add(usernameField);
	hb_Password.getChildren().add(passwordField);
	
	hb_Username.setPadding(new Insets(60, 0, 0, (windowSize.getWidth()/2)-50 ));
	hb_Password.setPadding(new Insets(90, 0, 0, (windowSize.getWidth()/2)-50 ));
	
	
	hb_dbName = new HBox();
	dbField = new TextField("Database name");
	hb_dbName.getChildren().add(dbField);
	hb_dbName.setPadding(new Insets(30,0,0, (windowSize.getWidth()/2)-50 ));


    Text text_CreatedDB = new Text("");
	
	loginButton = new Button();
	loginButton.setText("Login");
	loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {

			DB_Checker db_checker = new DB_Checker();
			Connection connection = db_checker.connectionDatabase(dbField.getText());

			if(connection!=null)
			{
				primaryStage.setTitle("Database Manager");
				primaryStage.setScene(new Db_Window(dbField.getText(), connection).getScene());
				text_CreatedDB.setText("");


				//Center Window
				Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
				primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
				primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
			}
			else
			{
				text_CreatedDB.setText("Can not connect to " + dbField.getText() + "database!");
			}

        }
    });

	createButton = new Button();
	createButton.setText("Create");
	createButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {

        	DB_Checker database = new DB_Checker();
            database.createDatabase(dbField.getText());
            text_CreatedDB.setText("Database has been created!");



        }
    });
	
	
	VBox vbox_button = new VBox(5);
	vbox_button.getChildren().addAll(loginButton, createButton, text_CreatedDB);
	vbox_button.setPadding(new Insets(120,0,0, (windowSize.getWidth()/2) ));
	
	StackPane layout = new StackPane();
        final boolean bolean = layout.getChildren().addAll(hb_Username, hb_Password, hb_dbName, vbox_button);
        Scene conecting_scene = new Scene(layout, windowSize.getHeight(), windowSize.getWidth());
		primaryStage.setScene(conecting_scene);
		primaryStage.show();
	}

	public static void main(String args[])
	{
		launch(args);
	}


}
