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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import objets.Livre;

/**
 *
 * @author cdi205
 */
public class LivreDB implements Serializable {

    private Connexion mc;

    public LivreDB() throws NamingException {
        this.mc = new Connexion();
    }

    public Livre find(String isbn) throws SQLException {
        String query = "SELECT * FROM Livre WHERE UPPER(isbn) = UPPER(?);";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {

            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            Livre obj = null;
            if (rs.next()) {
                obj = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), rs.getFloat("livPrix"), rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"));
            }
            rs.close();
            return obj;

        }
    }

    public List<Livre> findByName(String ouvNom) throws SQLException {
        String query = "SELECT * FROM Livre WHERE UPPER(ouvNom) = UPPER(?);";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            List<Livre> books = new ArrayList();
            while (rs.next()) {
                Livre obj = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), rs.getFloat("livPrix"), rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"));
                books.add(obj);
            }
            rs.close();
            pstmt.close();
            return books;

        }

    }

    public HashMap<Integer, List<Livre>> findByMotCle(int page, String motCle) throws SQLException {
        int elementParPage = 1;
        HashMap<Integer, List<Livre>> hm = new HashMap<>();
        String query = "DECLARE @PageNumber AS INT, @RowspPage AS INT "
                
                + "SET @PageNumber = ? "
                + "SET @RowspPage = ? "
                + "SELECT COUNT (*) OVER () AS resultat, liv.isbn, ediId, tvaId, proId, liv.ouvNom, livEdition, livDateEdition, livResume, livPrix, livStock, livImage, livSousTitre, livStatut, livChampLibre "
                + "From Livre liv "
                + "Join Recherche rec "
                + "ON liv.isbn = rec.isbn "
                + "Where rec.mocLibelle LIKE ? "
                + " ORDER BY liv.ouvNom"
                + " OFFSET ((@PageNumber - 1) * @RowspPage) ROWS"
                + " FETCH NEXT @RowspPage ROWS ONLY";

        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setInt(1, page);
            pstmt.setInt(2, elementParPage);
            pstmt.setString(3, "%" + motCle + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Livre> books = new ArrayList();
            int resultat = 0;
            while (rs.next()) {
                Livre obj = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), rs.getFloat("livPrix"), rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"));
                books.add(obj);
                resultat = rs.getInt("resultat");
            }
            rs.close();
            int nombrePage = (int) Math.ceil((double)resultat / elementParPage);
            hm.put(nombrePage, books);
            return hm;

        }
    }

    public HashMap<Integer, List<Livre>> findByTheme(int page, String theme) throws SQLException {      
        HashMap<Integer, List<Livre>> hm = new HashMap<>();
        int elementParPage = 1;
        String query = "DECLARE @PageNumber AS INT, @RowspPage AS INT "
                
                + "SET @PageNumber = ? "
                + "SET @RowspPage = ? "
                + "SELECT COUNT (*) OVER () AS resultat, liv.isbn, ediId, tvaId, proId, liv.ouvNom, livEdition, livDateEdition, livResume, livPrix, livStock, livImage, livSousTitre, livStatut, livChampLibre "
                + "From Livre liv "
                + "Join Appartenance app "
                + "On liv.ouvNom = app.ouvNom "
                + "join SousTheme sou "
                + "On app.souNom = sou.souNom "
                + "Where sou.theNom = ?"
                + " ORDER BY liv.ouvNom"
                + " OFFSET ((@PageNumber - 1) * @RowspPage) ROWS"
                + " FETCH NEXT @RowspPage ROWS ONLY";

        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setInt(1, page);
            pstmt.setInt(2, elementParPage);
            pstmt.setString(3, theme);
            ResultSet rs = pstmt.executeQuery();
            List<Livre> books = new ArrayList();
            int resultat = 0;
            while (rs.next()) {
                Livre obj = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), rs.getFloat("livPrix"), rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"));
                books.add(obj);
                resultat = rs.getInt("resultat");
            }
            rs.close();
            int nombrePage = (int) Math.ceil((double)resultat / elementParPage);
            hm.put(nombrePage, books);
            return hm;

        }

    }

    public HashMap<Integer, List<Livre>> rechercheAvancee(int page, String ouvNom, String isbn, String autNom, String autPrenom) throws SQLException {
        HashMap<Integer, List<Livre>> hm = new HashMap<>();
        List<Livre> books = null;

        String query = "DECLARE @PageNumber AS INT, @RowspPage AS INT "
                + "SET @PageNumber = ? "
                + "SET @RowspPage = 10 "
                + "SELECT COUNT (*) OVER () AS resultat, liv.isbn, ediId, tvaId, proId, liv.ouvNom, livEdition, livDateEdition, livResume, livPrix, livStock, livImage, livSousTitre, livStatut, livChampLibre "
                + "FROM Livre liv "
                + "JOIN Ecrire ecr "
                + "ON liv.ouvNom = ecr.ouvNom "
                + "JOIN Auteur aut "
                + "ON ecr.autId = aut.autId "
                + "WHERE "
                + " UPPER(liv.ouvNom) LIKE UPPER(?)"
                + " AND UPPER(liv.isbn) LIKE UPPER(?)"
                + " AND (UPPER(CONCAT(autNom, ' ',autPrenom)) LIKE UPPER(?) OR UPPER(CONCAT(autPrenom, ' ',autNom))  LIKE  UPPER(?))"
                + " ORDER BY liv.ouvNom"
                + " OFFSET ((@PageNumber - 1) * @RowspPage) ROWS"
                + " FETCH NEXT @RowspPage ROWS ONLY";

        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setInt(1, page);
            pstmt.setString(2, ouvNom);

            pstmt.setString(3, isbn);

            pstmt.setString(4, autNom + " " + autPrenom);
            //pstmt.setString(4, "%"+autPrenom+"%");

            if ("".equalsIgnoreCase(autPrenom)) {
                pstmt.setString(5, autNom);
                System.out.println(autNom);
            } else {
                pstmt.setString(5, autPrenom + " " + autNom);
                System.out.println(autNom + " " + autPrenom);
            }
            //pstmt.setString(6, "%"+autNom+"%");

            ResultSet rs = pstmt.executeQuery();
            books = new ArrayList();
            int resultat = 0;
            while (rs.next()) {
                Livre obj = new Livre(rs.getString("isbn"), rs.getLong("ediId"), rs.getLong("tvaId"), rs.getLong("proId"), rs.getString("ouvNom"), rs.getInt("livEdition"), rs.getDate("livDateEdition"), rs.getString("livResume"), rs.getFloat("livPrix"), rs.getInt("livStock"), rs.getString("livImage"), rs.getString("livSousTitre"), rs.getInt("livStatut"), rs.getString("livChampLibre"));
                books.add(obj);
                resultat = rs.getInt("resultat");
            }
            
            int nombrePage = (int) Math.ceil((double)resultat / 10);
            hm.put(nombrePage, books);
            rs.close();
        }
        return hm;
    }
}
