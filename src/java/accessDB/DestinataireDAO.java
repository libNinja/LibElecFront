package accessDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import beans.Destinataire;
import java.sql.Statement;

public class DestinataireDAO implements Serializable{

    private MaConnexion mc;
    

    
    public DestinataireDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    private Destinataire mapperDestinataire (ResultSet rs) throws SQLException{
        long cliId = Long.valueOf(rs.getString ("cliId"));
        Destinataire d = new Destinataire (cliId,rs.getString("desNom"), rs.getString("desPrenom"),rs.getString("desEmail"),rs.getString("desTel"),rs.getString("desStatut"));
        return d;
        
    }
        
    public Destinataire selectDesByIdClient (String id) throws SQLException {
      
        Destinataire d = null;
        
        String requete = " select cliId, desNom desPrenom,desEmail,desTel,desStatut from Destinataire where cliId = ?";
        
        try (Connection cnt = mc.getConnection(); PreparedStatement st = cnt.prepareStatement(requete)) {
            
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
           
            
            if (rs.next()) {
               d = mapperDestinataire(rs);
           }
        }
        return d;
    }
    
    
       public Destinataire insertDesInfo(String destinataireNom, String destinatairePrenom, String destinataireEmail, String destinataireTel) throws SQLException{
        
        Destinataire di = null;
           
        String requete = "insert into Destinataire (desNom desPrenom,desEmail,desTel) value ('"+destinataireNom+"','"+destinatairePrenom+"','"+destinataireEmail+"','"+destinataireTel+"')";
      
         try (Connection cnt = mc.getConnection();Statement stmt = cnt.createStatement()) {
            stmt.executeUpdate(requete);
         
        return di;
            }
       }  
       
        public Destinataire insertDesAdresse(String adresseAdrNumVoie,String adresseNomVoie,String adresseNomVoieSuite,String adresseCp,String adresseVille,String adressePays) throws SQLException{
        
        Destinataire da = null;
           
        String requete = "insert into Adresse (adrNumVoie,adrNomVoie,adrNomVoieSuite,adrCp,adrVille,adrPays) values ('"+adresseAdrNumVoie+"','"+adresseNomVoie+"','"+adresseNomVoieSuite+"','"+adresseCp+"','"+adresseVille+"','"+adressePays+"')";
      
        try (Connection cnt = mc.getConnection();Statement stmt = cnt.createStatement()) {
            stmt.executeUpdate(requete);
         
        return da;
            }
       } 
            
        
       // public Destinataire insertDesAdresse(){}        
             
          
}


