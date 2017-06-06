package accessDB;



        
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnexionPool implements Serializable {
    private DataSource ds;

    

    public ConnexionPool() throws NamingException {
        InitialContext ic = new InitialContext();
        ds = (DataSource) ic.lookup("jdbc/libelec");
        
    }
    
    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
}

