package Interface.Window;

import Interface.Window.DB_function.DB_Method;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.sql.*;

import static java.lang.System.exit;


public class Db_Window extends Conecting_Window {

    private Connection connection;

    protected Db_Window(String dbField1, Connection connection1) {
        String dbField = dbField1;
        connection = connection1;

    }


    public Db_Window() {
    }


    private Scene setScene() {
        Scene scene = null;

        DB_Method db_method = new DB_Method(connection);
        db_method.getTables();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

            }
        });

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                exit(0);
            }
        });


        fileMenu.getItems().addAll(openItem, exitItem);


        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");

        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);

        VBox hb_scene2 = new VBox();
        hb_scene2.getChildren().add(menuBar);
        scene = new Scene(hb_scene2, windowSize.getHeight() * 2.5, windowSize.getWidth() * 2.5);
        return scene;
    }

    public Scene getScene()
    {
        return setScene();
    }

    }

