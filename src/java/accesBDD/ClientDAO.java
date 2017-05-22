
package accesBDD;

import beans.Client;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;


public class ClientDAO implements Serializable{
    
    private MaConnexion mc;
    private Client client;
    
  
    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public void insertCliInfo(Client nvCli) throws SQLException{
        
           
        String requete = "insert into Client (cliGenre, cliNom, cliPrenom, cliEmail, cliMdp, cliDateAdhesion, cliTelF,cliTelM, cliStatut,cliChampLibre) values ('"+client.getCliGenre()+"', '"+client.getCliNom()+"','"+client.getCliPrenom()+"', '"+client.getCliEmail()+"', '"+client.getCliMdp()+"','"+client.getCliDateAdhesion()+"','"+client.getCliTelF()+"','"+client.getCliTelM()+"', '"+client.getCliStatut()+"','"+client.getCliChampLibre()+"')";
      
            try (Connection cnt = mc.getConnection();Statement stmt = cnt.createStatement()) {
            stmt.executeUpdate(requete);
        
            }catch(SQLException ex) {
            System.out.println("sql exception of insertion: " + ex.getMessage());
        }
        
        
       }  
    
    
  
    
    public void insert() {
        //TODO il faut verifier si le client existe avant sa creation dans la DB.
        try {
            if(client != null) {
                String query = "INSERT INTO  Client (cliGenre,cliPrenom,cliNom,cliEmail,cliMdp,cliDateAdhesion,cliTelF,cliTelM,cliStatut,cliChampLibre) "
                        + "VALUES"
                        + "(?, ?, ?, ?, ?, ?, ?, ?, ? );";
                       
                PreparedStatement pstmt = mc.getConnection().prepareStatement(query);
                
                pstmt.executeUpdate();
            }
        }catch(SQLException ex) {
            System.out.println("sql exception of insertion: " + ex.getMessage());
        }
    }
}
