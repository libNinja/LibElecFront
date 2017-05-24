/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import objets.SousTheme;
import objets.Theme;

/**
 *
 * @author cdi205
 */
public class SousThemeDB extends DB<SousTheme> {

    public boolean insert(SousTheme obj) {
        String query = "INSERT INTO SousTheme (souNom, theNom) "
                + "VALUES "
                + "(?, ?);";

        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getSouNom());
            pstmt.setString(2, obj.getTheNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   @Override
    public boolean update(SousTheme obj) {
        String query = "UPDATE SousTheme SET souNom = ?, theNom = ? WHERE souNom = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getSouNom());
            pstmt.setString(2, obj.getTheNom());
            pstmt.setString(3, obj.getSouNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean update(SousTheme obj, String oldSouNom) {
        String query = "UPDATE SousTheme SET souNom = ?, theNom = ? WHERE souNom = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getSouNom());
            pstmt.setString(2, obj.getTheNom());
            pstmt.setString(3, oldSouNom);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public SousTheme find(String souNom) {
        String query = "SELECT * FROM SousTheme WHERE souNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, souNom);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            SousTheme obj = new SousTheme(rs.getString("theNom"), rs.getString("souNom"));
            rs.close();
            pstmt.close();
            return obj;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Vector<SousTheme> findByTheme(Theme toFind) {
        String query = "SELECT * FROM SousTheme WHERE theNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, toFind.getTheNom());
            ResultSet rs = pstmt.executeQuery();
            Vector<SousTheme> sousThemeList = new Vector();

            while (rs.next()) {
                SousTheme obj = new SousTheme(rs.getString("theNom"), rs.getString("souNom"));
                System.out.println(obj);
                sousThemeList.add(obj);
            }
            rs.close();
            pstmt.close();
            return sousThemeList;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Vector<SousTheme> findFromOuvrage(String ouvNom){
        String query = "Select * FROM  SousTheme  sou JOIN Appartenance app ON sou.souNom = app.souNom WHERE app.ouvNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            Vector<SousTheme> sousThemeList = new Vector();

            while (rs.next()) {
                SousTheme obj = new SousTheme(rs.getString("theNom"), rs.getString("souNom"));
                System.out.println(obj);
                sousThemeList.add(obj);
            }
            rs.close();
            pstmt.close();
            return sousThemeList;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    

}
