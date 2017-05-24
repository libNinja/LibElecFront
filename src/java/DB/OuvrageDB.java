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
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Ouvrage;

/**
 *
 * @author Anis
 */
public class OuvrageDB extends DB<Ouvrage> {

    @Override
    public boolean insert(Ouvrage obj){
        String query = "INSERT INTO Ouvrage "+
                       "VALUES "+
                       "(?);";
        
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getOuvNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }   
    }
    
    @Override
    public boolean update(Ouvrage obj){
        String query = "UPDATE Ouvrage SET OuvNom = ? WHERE ouvNom = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getOuvNom());
            pstmt.setString(2, obj.getOuvNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public Ouvrage find(String ouvNom){
        String query = "SELECT * FROM Ouvrage Where ouvNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Ouvrage obj = new Ouvrage(rs.getString("ouvNom"));
            rs.close();
            pstmt.close();
            return obj;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Vector<Ouvrage> loadAll() {
        String query = "SELECT * FROM Ouvrage";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Vector<Ouvrage> data = new Vector();
            while(rs.next()) {
                Ouvrage obj = new Ouvrage(rs.getString("ouvNom"));
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
