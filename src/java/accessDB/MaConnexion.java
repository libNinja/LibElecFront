 package accessDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MaConnexion implements Serializable{
    private DataSource ds;

    public MaConnexion() throws NamingException {
        InitialContext ic = new InitialContext();
        ds = (DataSource) ic.lookup("jdbc/libElec");
    }
    
    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
}
