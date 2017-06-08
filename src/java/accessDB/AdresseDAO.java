
package accessDB;

import beans.Adresse;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;


public class AdresseDAO implements Serializable{
    
    private MaConnexion mc;
    private Adresse adresse;
    
    public AdresseDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public AdresseDAO(Adresse adresse) throws NamingException {
        mc = new MaConnexion();
        this.adresse = adresse;
    }
    
    public void insertAdrInfo() throws SQLException{
        String query = "INSERT INTO Adresse (desId,cliId,cli_cliId,adrNumVoie,adrNomVoie,adrNomVoieSuite,adrCp,adrVille,adrPays,adrStatut) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)){
            
            if(adresse != null) {
                
                     
                pstmt.setLong(1, adresse.getDesId());
                pstmt.setLong(2, adresse.getCliId());
                pstmt.setLong(3, adresse.getCli_cliId());
                pstmt.setInt(4, adresse.getAdrNumVoie());
                pstmt.setString(5, adresse.getAdrNomVoie());
                pstmt.setString(6, adresse.getAdrNomVoieSuite());
                pstmt.setString(7, adresse.getAdrCp());
                pstmt.setString(8, adresse.getAdrVille());
                pstmt.setString(9, adresse.getAdrPays());
                pstmt.setInt(10, adresse.getAdrStatut());
                
                System.out.println("pays " + adresse.getAdrPays());
                
                pstmt.executeUpdate();
                
                
            }
            System.out.println("insertion client : ok" );
        }
       }  

}
