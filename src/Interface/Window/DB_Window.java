package Interface.Window;

import Interface.Window.Conecting_Window;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DB_Window extends Conecting_Window{


	String dbField;
	String usernameField;
	String passwordField;
	Scene DB_scene;
	
	static double windowHeight = 300;
	static double windowWidth = 250;
	

	public DB_Window(String dbField, String usernameField, String passwordField)
	{
		this.dbField=dbField;
		this.usernameField=usernameField;
		this.passwordField=passwordField;
	}
	

	Scene setScene() {
		Group group = new Group();
		Button button = new Button("Button1");
		group.getChildren().addAll(new Label("Scene 1"), group);
		
		Scene scene_2 = new Scene(group, windowHeight, windowWidth);
		return scene_2;
	}
	
	
}

