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
import objets.Appartenance;
import objets.Auteur;

/**
 *
 * @author Anis
 */
public class AppartenanceDB extends DB<Appartenance>{
    @Override
    public boolean insert(Appartenance obj) {
        String query = "INSERT INTO Appartenance(souNom, ouvNom) "
                + "VALUES "
                + "(?, ?);";

        PreparedStatement pstmt;
        
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getSouNom());
            pstmt.setString(2, obj.getOuvNom());

            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Appartenance obj){
        return false;
    }
    
    public boolean delete(Appartenance obj) {
        String query = "DELETE FROM Appartenance WHERE ouvNom = ? AND souNom = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getOuvNom());
            pstmt.setString(2, obj.getSouNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   public Vector<Appartenance> find(String ouvNom) {
        String query = "SELECT * FROM Appartenance WHERE ouvNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            Vector<Appartenance> data = new Vector();
            while(rs.next()) {
                Appartenance obj = new Appartenance(rs.getString("ouvNom"), rs.getString("souNom"));
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
    
        public Vector<Appartenance> loadAll() {
        String query = "SELECT * FROM Appartenance";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Vector<Appartenance> data = new Vector();
            while(rs.next()){
                Appartenance obj = new Appartenance(rs.getString("ouvNom"), rs.getString("souNom"));
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
