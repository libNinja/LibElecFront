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
import objets.recherche;

/**
 *
 * @author Anis
 */
public class rechercheDB extends DB<recherche>{
    
    @Override
    public boolean insert(recherche obj) {
        String query = "INSERT INTO recherche(mocLibelle, isbn) "
                + "VALUES "
                + "(?, ?);";

        PreparedStatement pstmt;
        
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getMocLibelle());
            pstmt.setString(2, obj.getIsbn());

            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(recherche obj){
        return false;
    }
    
    public boolean delete(recherche obj) {
        String query = "DELETE FROM recherche WHERE mocLibelle = ? AND isbn = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getMocLibelle());
            pstmt.setString(2, obj.getIsbn());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   public Vector<recherche> find(String isbn) {
        String query = "SELECT * FROM recherche WHERE isbn = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            Vector<recherche> data = new Vector();
            while(rs.next()) {
                recherche obj = new recherche(rs.getString("mocLibelle"), rs.getString("isbn"));
                data.add(obj);
            }
            rs.close();
            pstmt.close();
            return data;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
        public Vector<recherche> loadAll() {
        String query = "SELECT * FROM recherche";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Vector<recherche> data = new Vector();
            while(rs.next()){
                recherche obj = new recherche(rs.getString("mocLibelle"), rs.getString("isbn"));
                data.add(obj);
            }
            
            rs.close();
            pstmt.close();
            return data;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
