
package accessDB;

import beans.Client;
import java.io.Serializable;
import java.sql.Connection;
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
    
    public ClientDAO(Client client) throws NamingException {
        mc = new MaConnexion();
        this.client = client;
    }
    
    public void insertCliInfo() throws SQLException{
        String query = "INSERT INTO Client (cliGenre,cliPrenom,cliNom,cliEmail,cliMdp,cliDateAdhesion,cliTelF,cliTelM, cliStatut) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection cnt = mc.getConnection(); PreparedStatement pstmt = cnt.prepareStatement(query)){
            System.out.println(client.getCliGenre());
            if(client != null) {
                
                     
                pstmt.setInt(1, client.getCliGenre());
                pstmt.setString(2, client.getCliPrenom());
                pstmt.setString(3, client.getCliNom());
                pstmt.setString(4, client.getCliEmail());
                pstmt.setString(5, client.getCliMdp());
                pstmt.setString(6, client.getCliDateAdhesion());
                pstmt.setString(7, client.getCliTelF());
                pstmt.setString(8, client.getCliTelM());
                pstmt.setInt(9, client.getCliStatut());
                
                System.out.println("prenom " + client.getCliPrenom());
                
                pstmt.executeUpdate();
                
                
            }
            System.out.println("insertion client : ok" );
        }
       }  

}
