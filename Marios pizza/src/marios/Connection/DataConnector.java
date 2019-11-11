

package marios.Connection;

import java.sql.*;


public class DataConnector {
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://root@localhost:3306/mariospizza";
        //establish connection object
        Connection conn = DriverManager.getConnection(url, "root", "Chri196hfpy79arr");

        return conn;
    }

}
