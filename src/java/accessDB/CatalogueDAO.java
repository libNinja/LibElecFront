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
import beans.Livre;

/**
 *
 * @author cdi204
 */
public class CatalogueDAO implements Serializable{
    private MaConnexion mc;

    public CatalogueDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    private Livre mapperLivre(ResultSet rs) throws SQLException{
        float f = Float.valueOf(rs.getString("livPrix"));
        Livre l = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), f, rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"), rs.getFloat("proReduction"));
        return l;
    }
    
    public List<Livre> selectAllLivres() throws SQLException {
        List<Livre> ll = new ArrayList<>();
        try (Connection cnt = mc.getConnection(); Statement st = cnt.createStatement()) {
            String req = "select isbn, ediId, tvaId, liv.proId, ouvNom, livEdition, livDateEdition, livResume, livPrix, pro.proReduction, livStock, livImage, livSousTitre, livStatut, livChampLibre from LIVRE liv join Promotion pro on pro.proId=liv.proId";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Livre l = mapperLivre(rs);
                ll.add(l);
            }
        }
        return ll;
    }
    
     public Livre selectLivreById(String ref) throws SQLException{
        Livre l = null;
        String req = "select isbn, ediId, tvaId, liv.proId, ouvNom, livEdition, livDateEdition, livResume, livPrix, pro.proReduction, livStock, livImage, livSousTitre, livStatut, livChampLibre from LIVRE liv join Promotion pro on pro.proId=liv.proId "
                + " where isbn = ?";
         System.out.println("req= "+req);
        try (Connection cnt = mc.getConnection(); PreparedStatement st = cnt.prepareStatement(req)) {
            st.setString(1, ref);
            ResultSet rs = st.executeQuery();
           if (rs.next()) {
               l = mapperLivre(rs);
           }
        }
        return l;
    }
    
    
    
}
