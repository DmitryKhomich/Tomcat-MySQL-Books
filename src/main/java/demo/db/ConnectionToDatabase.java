package demo.db;

import demo.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {

    public static Connection connectToDB(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(Constants.DB_URL + Constants.DB_NAME , Constants.DB_USER , Constants.PASS);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }
}
