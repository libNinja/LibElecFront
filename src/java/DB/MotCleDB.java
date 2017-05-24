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
import objets.MotCle;
/**
 *
 * @author Anis
 */
public class MotCleDB extends DB<MotCle> {

    @Override
    public boolean insert(MotCle obj) {
        String query = "INSERT INTO MotCle(mocLibelle) "
                + "VALUES "
                + "(?);";

        PreparedStatement pstmt;

        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getMocLibelle());

            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(MotCle obj) {
        return false;
    }

    public boolean delete(MotCle obj) {
        String query = "DELETE FROM MotCle WHERE mocLibelle = ?;";
        PreparedStatement pstmt;
        try {
            pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, obj.getMocLibelle());

            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Vector<MotCle> find(String isbn) {
        String query = "Select * FROM recherche WHERE isbn = ?";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            Vector<MotCle> data = new Vector();
            while(rs.next()){
                MotCle obj = new MotCle(rs.getString("mocLibelle"));
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
    
    public Vector<MotCle> loadAll() {
        String query = "Select * FROM recherche";
        try {
            PreparedStatement pstmt = Connexion.connexion.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Vector<MotCle> data = new Vector();
            while(rs.next()){
                MotCle obj = new MotCle(rs.getString("mocLibelle"));
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
