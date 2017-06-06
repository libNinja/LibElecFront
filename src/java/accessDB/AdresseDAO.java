package accessDB;


import accessDB.DAOInterface;
import accessDB.ConnexionPool;
import beans.Client;
import beans.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

public class AdresseDAO implements DAOInterface{
    private Adresse adresse;
    private Statement stmt;
    private PreparedStatement pstmt;
    private String query;
    private ConnexionPool connexionPool;
    private Connection connection;
    
    
    public AdresseDAO() throws NamingException {
         connexionPool = new ConnexionPool();
        
        try {
            connection = connexionPool.getConnection();
        }catch(SQLException ex) {
            System.err.println("connection to pool : /" + ex.getMessage());   
        }
    }

    @Override
    public void insert(Object adresseNouveauMembre) {
         //TODO il faut verifier si le client existe avant sa creation dans la DB.
        adresse = (Adresse) adresseNouveauMembre; 
        try {
            if(adresse != null) {
                String query = "INSERT INTO  Adresse "
                        + "(cliId, adrNumVoie,adrNomVoie,adrNomVoieSuite,adrCp,adrVille,adrPays, adrStatut) "
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?);";
                       
                pstmt = connection.prepareStatement(query);
                
                pstmt.setLong(1, adresse.getCliId());
                pstmt.setInt(2, adresse.getAdrNumVoie());
                pstmt.setString(3, adresse.getAdrNomVoie());
                pstmt.setString(4, adresse.getAdrNomVoieSuite());
                pstmt.setString(5, adresse.getAdrCp());
                pstmt.setString(6, adresse.getAdrVille());
                pstmt.setString(7, adresse.getAdrPays());
                
                pstmt.setInt(8, adresse.getAdrStatut());
                
                pstmt.executeUpdate();
                
                System.out.println("insertion client : ok" );
            }
        }catch(SQLException ex) {
            System.out.println("sql exception of insertion (adresse): " + ex.getMessage());
        }
    }
    
    

    @Override
    public void update(Object adresse) {
      
    }
    
}
