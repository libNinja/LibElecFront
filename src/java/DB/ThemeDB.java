/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import objets.Theme;

/**
 *
 * @author cdi205
 */
public class ThemeDB implements Serializable {
    private Connexion mc;

    public ThemeDB() throws NamingException {
        this.mc = new Connexion();
    }
    
    
 
    


    public Theme find(String theNom) throws SQLException {
        String query = "SELECT * FROM Theme WHERE theNom = ?";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, theNom);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Theme obj = new Theme(rs.getString("theNom"));
            rs.close();
            return obj;
        }    
    }
    
    public List<Theme> loadAll() throws SQLException {
        String query = "SELECT theNom FROM Theme";
         try (Connection cnt = mc.getConnection(); Statement stmt = cnt.createStatement()) { 
            ResultSet rs = stmt.executeQuery(query);
            List<Theme> themeList = new ArrayList();
            while(rs.next()){
                Theme obj = new Theme(rs.getString("theNom"));
                themeList.add(obj);
            }
            rs.close();
            return themeList;
        }
    }
    
    public Theme findFromLivre(String ouvNom) throws SQLException {
        String query = "Select * FROM  SousTheme  sou JOIN Appartenance app ON sou.souNom = app.souNom WHERE UPPER(app.ouvNom) = UPPER(?)";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Theme obj = new Theme(rs.getString("theNom"));
            rs.close();
            pstmt.close();
            return obj;
        }
    } 
}
