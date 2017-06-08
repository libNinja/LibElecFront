package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBUtil {
    private String url;
    private String query;
    private PreparedStatement pstmt;
    private Statement stmt;
    //    
    private Connection connexion;
    
   
    public DBUtil() {
        initDB();
    }
    
    public void initDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException ex) {
            System.err.println("class driver non trouvé /" + ex.getMessage());
        }
        
        connexion = null;
        
        try{
            url = "jdbc:sqlserver://localhost:1433;"
                    +"databaseName=libelec;user=sa;password=sa";
            connexion = DriverManager.getConnection(url);
        }catch(SQLException ex) {
            System.err.println("Oops:Connection  " + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void disconnect() {
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return;
        }

        System.out.println("Done!");
    }
   
}



