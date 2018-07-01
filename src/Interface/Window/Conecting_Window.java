package Interface.Window;


import Interface.Window.DB_Window;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Conecting_Window extends Application {

	public class Db_Window{
		
		String dbField;
		String usernameField;
		String passwordField;
		Scene DB_scene;
		

		Scene setScene() {
			Group group = new Group();
			Button button = new Button("Button1");
			group.getChildren().addAll(new Label("Scene 1"), group);
			
			Scene scene_2 = new Scene(group, windowHeight, windowWidth);
			return scene_2;
		}
	}
	
	
	static double windowHeight = 300;
	static double windowWidth = 250;


	Button loginButton;
	Button createButton;
	
	HBox hb_dbName;
	TextField dbField;
	
	HBox hb_Username;
	TextField usernameField;
	
	HBox hb_Password;
	PasswordField passwordField;
	
	public static void main(String args[])
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
	primaryStage.setTitle("DataBase_Manager");
	
	
	hb_Username = new HBox();
	usernameField=  new TextField();
	usernameField.setText("username");
	

	
	hb_Password = new HBox();
	passwordField = new PasswordField();
	passwordField.setText("passowrd");
	
	hb_Username.getChildren().add(usernameField);
	hb_Password.getChildren().add(passwordField);
	
	hb_Username.setPadding(new Insets(60, 0, 0, (windowWidth/2)-50 ));
	hb_Password.setPadding(new Insets(90, 0, 0, (windowWidth/2)-50 ));
	
	
	hb_dbName = new HBox();
	dbField = new TextField("Database name");
	hb_dbName.getChildren().add(dbField);
	hb_dbName.setPadding(new Insets(30,0,0, (windowWidth/2)-50 ));
	
	
	
	loginButton = new Button();
	loginButton.setText("Login");
	loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
      
        	System.out.println("Login -> " + "DbName:" + dbField.getText() + " Username:" +  usernameField.getText() + " password:" + passwordField.getText());
        	DB_Window db_window = new DB_Window(dbField.getText(), usernameField.getText(), passwordField.getText());
        	primaryStage.setScene(db_window.setScene());
        }
    });
	
	createButton = new Button();
	createButton.setText("Create");
	createButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            
        	System.out.println("Create -> " + "DbName:" + dbField.getText() + " Username:" +  usernameField.getText() + " password:" + passwordField.getText());
        }
    });
	
	
	VBox vbox_button = new VBox(5);
	vbox_button.getChildren().addAll(loginButton, createButton);
	vbox_button.setPadding(new Insets(120,0,0, (windowWidth/2) ));
	
	StackPane layout = new StackPane();
	layout.getChildren().addAll(hb_Username, hb_Password, hb_dbName, vbox_button);
	
	Scene conecting_scene = new Scene(layout, windowHeight, windowWidth);
	primaryStage.setScene(conecting_scene);
	primaryStage.show();
	}

}
