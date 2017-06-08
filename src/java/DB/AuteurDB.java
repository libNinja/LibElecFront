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
import java.util.List;
import javax.naming.NamingException;
import objets.Auteur;

/**
 *
 * @author cdi205
 */
public class AuteurDB implements Serializable {

    private Connexion mc;

    public AuteurDB() throws NamingException {
        this.mc = new Connexion();
    }

    public List<Auteur> loadAll() throws SQLException {
        String query = "SELECT * FROM Auteur";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            List<Auteur> data = new ArrayList();
            while (rs.next()) {
                Auteur obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
                data.add(obj);
            }
            rs.close();
            return data;
        }
    }

    public List<Auteur> findByName(String autNom, String autPrenom) throws SQLException {
        String query = "SELECT * FROM Auteur WHERE UPPER(autNom) = UPPER(?) and UPPER(autPrenom) = UPPER(?)";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, autNom);
            pstmt.setString(2, autPrenom);
            ResultSet rs = pstmt.executeQuery();
            List<Auteur> recherche = new ArrayList();
            while (rs.next()) {
                Auteur obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
                recherche.add(obj);
            }
            rs.close();
            return recherche;
        }

    }

    public List<Auteur> findByNom(String autNom) throws SQLException {
        String query = "SELECT * FROM Auteur WHERE UPPER(autNom) = UPPER(?)";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, autNom);
            ResultSet rs = pstmt.executeQuery();
            List<Auteur> recherche = new ArrayList();
            while (rs.next()) {
                Auteur obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
                recherche.add(obj);
            }
            rs.close();
            return recherche;

        }
    }

    public List<Auteur> findByPrenom(String autPrenom) throws SQLException {
        String query = "SELECT * FROM Auteur WHERE UPPER(autPrenom) = UPPER(?)";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, autPrenom);
            ResultSet rs = pstmt.executeQuery();
            List<Auteur> recherche = new ArrayList();
            while (rs.next()) {
                Auteur obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
                recherche.add(obj);
            }
            rs.close();
            return recherche;
        }
    }

    public Auteur find(String ouvNom) throws SQLException {
        String query = "SELECT * FROM Auteur aut JOIN Ecrire ecr ON aut.autId = ecr.autId WHERE ouvNom = ?";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, ouvNom);
            ResultSet rs = pstmt.executeQuery();
            Auteur obj = null;
            if (rs.next()) {
                obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
            }
            rs.close();
            return obj;
        }
    }

    public List<Auteur> findByIsbn(String isbn) throws SQLException {
        String query = "SELECT aut.autId, autNom, autPrenom, autDateNaissance, autGenre, autBio FROM Auteur aut "
                + "JOIN Ecrire ecr "
                + "ON aut.autId = ecr.autId "
                + "JOIN Livre liv "
                + "ON ecr.ouvNom = liv.ouvNom "
                + "WHERE liv.isbn = ?";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            List<Auteur> recherche = new ArrayList();
            while (rs.next()) {
                Auteur obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
                recherche.add(obj);
            }
            rs.close();
            return recherche;
        }
    }
    
    public Auteur findById(String autId) throws SQLException {
        String query = "SELECT autId, autNom, autPrenom, autDateNaissance, autGenre, autBio FROM Auteur "
                +"WHERE autId = ?";
 
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)) {
            pstmt.setFloat(1, Float.valueOf(autId));
            ResultSet rs = pstmt.executeQuery();
            Auteur obj = null;
            if (rs.next()) {
                obj = new Auteur(rs.getLong("autId"), rs.getString("autNom"), rs.getString("autPrenom"), rs.getDate("autDateNaissance"), rs.getShort("autGenre"), rs.getString("autBio"));
            }
            rs.close();
            return obj;
        }
    }

}
