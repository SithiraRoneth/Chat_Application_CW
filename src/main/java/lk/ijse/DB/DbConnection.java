/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:13
 * Project Name :Chat_Application
 * */
package lk.ijse.DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection db;
    private Connection connection;
    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/chat",
                "root",
                "1234"
        );
    }

    public static DbConnection getInstance() throws SQLException {
        return db == null ? db = new DbConnection() : db ;
    }
    public Connection getConnection(){
        return connection;
    }
}
