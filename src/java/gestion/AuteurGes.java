/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import DB.AuteurDB;
import DB.LivreDB;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import objets.Auteur;

/**
 *
 * @author cdi205
 */
public class AuteurGes {
      private AuteurDB ad;

    public AuteurGes() throws NamingException {
        this.ad = new AuteurDB();
    }
  
    public List<Auteur> findByIsbn(String isbn) throws SQLException{
        isbn = isbn.trim();
        return ad.findByIsbn(isbn);
    }
    
    public Auteur findById(String autId) throws SQLException {
        return ad.findById(autId);
    }
}
