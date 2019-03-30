
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HSQLDBConnection {
    private static Boolean tableExists = false;

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("HSQLDB JDBCDriver Loaded");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
            if (!tableExists) {
                PreparedStatement preparedStmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS  users (name varchar(30) , login varchar(30) , email  varchar(30), password varchar(30), isPremium bit , isAdmin bit )");
                preparedStmt.executeUpdate();
                tableExists = true;
            }
            System.out.println("HSQLDB Connection Created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}






