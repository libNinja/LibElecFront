package UtilDB;



        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class Connexion {

    public static Connection connection = null;

    public static void toConnect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return;
        }

        try {
            
//            connection = DriverManager.getConnection(
//                    "jdbc:sqlserver://localhost:1433;"
//                    + "databaseName=libelec;user=sa;password=sa");

                        connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=libelec;user=sa;password=saObito95000_");
             
            System.out.println("okokok");
                        
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
        }

        
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return;
        }

        System.out.println("Done!");
    }
}

