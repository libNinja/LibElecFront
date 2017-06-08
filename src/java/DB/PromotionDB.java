/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import objets.Livre;
import objets.Promotion;

/**
 *
 * @author cdi205
 */
public class PromotionDB {
    private Connexion mc;   

    public PromotionDB() throws NamingException {
        this.mc = new Connexion();
    }
    
    public Promotion find(long id) throws SQLException {
        String query = "SELECT proId, proNom, proDateDebut, proDateFin, proDescription, proReduction, proImage, proStatut, proChampLibre FROM Promotion WHERE proId = ?";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            Promotion obj = null;
            if (rs.next()) {
                 obj = new Promotion(rs.getLong("proId"), rs.getString("proNom"), rs.getDate("proDateDebut"), rs.getDate("proDateFin"), rs.getString("proDescription"), rs.getFloat("proReduction"), rs.getString("proImage"), rs.getInt("proStatut"), rs.getString("proChampLibre"));
                
            }
            rs.close();
            return obj;

        }
    }
}
