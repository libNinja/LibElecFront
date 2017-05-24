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
import objets.Ecrit;
import objets.Editeur;

/**
 *
 * @author Anis
 */
public class EcritDB extends DB<Ecrit> {

    @Override
    public boolean insert(Ecrit obj) {
        String query = "insert into Ecrire(autId, ouvNom) values (?,?)";

        PreparedStatement pstmt;

        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, obj.getAutId());
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
    public boolean update(Ecrit obj) {

        // String query = "update tva set tvaId = ? where tvaTaux = ?";
        String query = "update Ecrire set autId = ?, ouvNom = ?";

        PreparedStatement pstmt;

        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, obj.getAutId());
            pstmt.setString(2, obj.getOuvNom());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Ecrit find(long autId, String ouvNom) {
        String query = "SELECT * FROM Ecrire WHERE autId = ?, ouvNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, autId);
            pstmt.setString(2, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Ecrit obj = new Ecrit(rs.getLong("autId"), rs.getString("ouvNom"));
            return obj;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Vector<Ecrit> find(long autId){
        String query = "SELECT * FROM Ecrire WHERE autId = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setLong(1, autId);
            
            ResultSet rs = pstmt.executeQuery();
            Vector<Ecrit> data = new Vector();
            while(rs.next()){
                Ecrit obj = new Ecrit(rs.getLong("autId"), rs.getString("ouvNom"));
                data.add(obj);              
            }
            
            return data;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Vector<Ecrit> find(String ouvNom){
        String query = "SELECT * FROM Ecrire WHERE ouvNom = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, ouvNom);
            
            ResultSet rs = pstmt.executeQuery();
            Vector<Ecrit> data = new Vector();
            while(rs.next()){
                Ecrit obj = new Ecrit(rs.getLong("autId"), rs.getString("ouvNom"));
                data.add(obj);              
            }
            
            return data;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void delete(Ecrit toDelete){
        String query = "DELETE FROM Ecrire WHERE ouvNom = ? AND autId = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, toDelete.getOuvNom());
            pstmt.setLong(2, toDelete.getAutId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
