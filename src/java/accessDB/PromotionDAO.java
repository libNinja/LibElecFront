/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import beans.Evenement;

/**
 *
 * @author cdi204
 */
public class PromotionDAO implements Serializable {

    private MaConnexion mc;

    public PromotionDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public Evenement mapperEvenement(ResultSet rs) throws SQLException {
        float f = Float.valueOf(rs.getString("proReduction"));
        Evenement e = new Evenement(rs.getLong("proId"), rs.getString("proNom"), rs.getDate("proDateDebut"), rs.getDate("proDateFin"), rs.getString("proDescription"), f, rs.getString("proImage"), rs.getInt("proStatut"), rs.getString("proChampLibre"));
        return e;
    }

    public List<Evenement> selectAllEvenements() throws SQLException {
        List<Evenement> le = new ArrayList<>();
        try (Connection cnt = mc.getConnection(); Statement st = cnt.createStatement()) {
            String req = "select proId, proNom, proDateDebut, proDateFin, proDescription, proReduction, proImage, proStatut, proChampLibre from Promotion";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Evenement l = mapperEvenement(rs);
                le.add(l);
            }

        }
        return le;
    }
    
    public Evenement selectEvenementByReduction(String ref) throws SQLException{
        Evenement e = null;
        String req = "select isbn, ediId, tvaId, liv.proId, ouvNom, livEdition, livDateEdition, livResume, livPrix, pro.proReduction, livStock, livImage, livSousTitre, livStatut, livChampLibre from LIVRE liv join Promotion pro on pro.proId=liv.proId where isbn = ?";
        System.out.println("req= "+ req);
        try(Connection cnt = mc.getConnection(); PreparedStatement st = cnt.prepareStatement(req)){
            st.setString(1, ref);
            ResultSet rs = st.executeQuery();
           if (rs.next()) {
               e = mapperEvenement(rs);
           }
            
        }
        return e;
    }
}
