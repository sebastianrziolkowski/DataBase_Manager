package Interface.Window.DB_function;

import Interface.Window.Db_Window;
import javafx.scene.control.TreeItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB_Method extends Db_Window {

    Connection connection = null;

    public DB_Method(Connection connection1) {
        connection = connection1;
    }

    public List getTables() {

        List<String> tableList = new ArrayList<String>();

        try {

            Statement statement = connection.createStatement();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);

            while (rs.next())
                tableList.add(rs.getString(3));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }


    public ArrayList<TreeItem> getTable()
    {
        ArrayList<TreeItem> tables = new ArrayList<TreeItem>();


        return tables;
    }


}
