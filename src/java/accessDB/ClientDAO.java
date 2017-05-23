package accessDB;

import accessDB.DAOInterface;
import accessDB.Connexion;
import beans.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TODO il ne faut pas oublier le Pool de connection a creer
public class ClientDAO implements DAOInterface{
    private Client client;
    
    private Statement stmt;
    private PreparedStatement pstmt;
    private String query;
    
    
    public ClientDAO() {
        
        Connexion.toConnect();
    }
    
    public ClientDAO(Client client) {
        this.client = client;
        
        Connexion.toConnect();
    }
    
    
    public Client loadFromDB(String email) {
        ResultSet rs;
        boolean check = false;
        Client client = null;
        
        try {
            query = "SELECT * FROM Client WHERE cliEmail = '" + email + "' ;";
            stmt = Connexion.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                
                if( !rs.getString("cliEmail").isEmpty()) {
                    
                    client = new Client();
                    
                    client.setCliId(rs.getLong("cliId"));
                    client.setCliGenre(rs.getInt("cliGenre"));
                    client.setCliPrenom(rs.getString("cliPrenom"));
                    client.setCliNom(rs.getString("cliNom"));
                    client.setCliEmail(rs.getString("cliEmail"));
                    client.setCliMdp(rs.getString("cliMdp"));
                    client.setCliDateAdhesion(rs.getString("cliDateAdhesion"));
                    client.setCliTelF(rs.getString("cliTelF"));
                    client.setCliTelM(rs.getString("cliTelM"));
                    client.setCliStatut(rs.getInt("cliStatut"));
                    client.setCliChampLibre(rs.getString("cliChampLibre"));
                }
            }
        }catch(SQLException ex) {
            System.out.println("erreur chargement client / " + ex.getMessage());
        }
        
        return client;
    }
    
    @Override
    public void insert() {
        //TODO il faut verifier si le client existe avant sa creation dans la DB.
        try {
            if(client != null) {
                String query = "INSERT INTO  Client "
                        + "(cliGenre,cliPrenom,cliNom,cliEmail,cliMdp,cliDateAdhesion,cliTelF, cliStatut) "
                        + "VALUES"
                        + "(?, ?, ?, ?, ?, ?, ?, ?);";
                       
                pstmt = Connexion.connection.prepareStatement(query);
                pstmt.setInt(1, client.getCliGenre());
                pstmt.setString(2, client.getCliPrenom());
                pstmt.setString(3, client.getCliNom());
                pstmt.setString(4, client.getCliEmail());
                pstmt.setString(5, client.getCliMdp());
                pstmt.setString(6, client.getCliDateAdhesion());
                pstmt.setString(7, client.getCliTelF());
                pstmt.setInt(8, client.getCliStatut());
                
                System.out.println("prenom " + client.getCliPrenom());
                
                pstmt.executeUpdate();
                
                System.out.println("insertion client : ok" );
            }
        }catch(SQLException ex) {
            System.out.println("sql exception of insertion: " + ex.getMessage());
        }
    }
    
    @Override
    public void update() {
    }
    
    
    public void search(Client client) {
//          ResultSet rs;
//
//        try {
//            query = "SELECT * FROM Client WHERE cliEmail = " + email;
//            stmt = connexion.connection.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//
//            rs = stmt.executeQuery(query);
//            while(rs.next()) {
//                client = new Client();
//
//                client.setCliId(rs.getLong("cliId"));
//                client.setCliGenre(rs.getInt("cliGenre"));
//                client.setCliPrenom(rs.getString("cliPrenom"));
//                client.setCliNom(rs.getString("cliNom"));
//                client.setCliEmail(rs.getString("cliEmail"));
//                client.setCliMdp(rs.getString("cliMdp"));
//                client.setCliDateAdhesion(rs.getString("cliDateAdhesion"));
//                client.setCliTelF(rs.getString("cliTelF"));
//                client.setCliTelM(rs.getString("cliTelM"));
//                client.setCliStatut(rs.getInt("cliStatut"));
//                client.setCliChampLibre(rs.getString("cliChampLibre"));
//            }
//        }catch(SQLException ex) {
//            System.out.println("erreur chargement client / " + ex.getMessage());
//        }
//
//        return client;
    }
    
    public boolean isExists(String email) {
        ResultSet rs;
        boolean check = false;
        
        try {
            query = "SELECT * FROM Client WHERE cliEmail = '" + email + "';";
            stmt = Connexion.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                
                check = !rs.getString("cliEmail").isEmpty();
                
            }
        }catch(SQLException ex) {
            System.out.println("erreur chargement client / " + ex.getMessage());
        }
        
        return check;
    }
    
    
    
}
