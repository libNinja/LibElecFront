
package gestion;

import java.io.Serializable;
import javax.naming.NamingException;
import accesBDD.DestinataireDAO;
import java.sql.SQLException;
import beans.Destinataire;
import java.util.Collection;
import java.util.HashMap;
import gestion.GestionDestinataire;


public class GestionDestinataire implements Serializable{
    private DestinataireDAO dd;

    public GestionDestinataire() throws NamingException {
         dd = new DestinataireDAO();
   
         
    }
    
    public Destinataire findDesByIdClient (String id) throws IllegalArgumentException, SQLException{
        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("l'id client est invalide");
        }
        id = id.trim();
        return dd.selectDesByIdClient(id);
    }
    
    public Destinataire insertDes (String destinataireNom, String destinatairePrenom, String destinataireEmail, String destinataireTel)throws IllegalArgumentException, SQLException{
        if(destinataireNom == null || destinatairePrenom == null|| destinatairePrenom.trim().isEmpty() ||destinatairePrenom.trim().isEmpty()){
            throw new IllegalArgumentException("tous les champs obligatoires ne sont pas remplis");
        }
        destinataireNom = destinataireNom.trim();
        destinatairePrenom = destinatairePrenom.trim();
        destinataireEmail = destinataireEmail.trim();
        destinataireTel = destinataireTel.trim();
        
        return dd.insertDesInfo(destinataireNom, destinatairePrenom, destinataireEmail, destinataireTel);
    }
    
    public Destinataire insertDesAdr (String adresseAdrNumVoie,String adresseNomVoie,String adresseNomVoieSuite,String adresseCp,String adresseVille,String adressePays)throws IllegalArgumentException, SQLException{
        
        
        adresseAdrNumVoie = adresseAdrNumVoie.trim();
        adresseNomVoie = adresseNomVoie.trim();
        adresseNomVoieSuite = adresseNomVoieSuite.trim();
        adresseCp = adresseCp.trim();
        adresseVille = adresseVille.trim();
        adressePays = adressePays.trim();
        
        return dd.insertDesAdresse(adresseAdrNumVoie,adresseNomVoie,adresseNomVoieSuite,adresseCp,adresseVille,adressePays);
    }
   
    

}
