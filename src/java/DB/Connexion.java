/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author cdi205
 */
public class Connexion implements Serializable{

    private DataSource ds;

    public Connexion() throws NamingException {
        InitialContext ic = new InitialContext();
        ds = (DataSource) ic.lookup("jdbc/libElec");
    }
    
    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
}
