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
    private Connexion connexion;
    private Statement stmt;
    private PreparedStatement pstmt;
    private String query;
    
    public ClientDAO(Client client) {
        this.client = client;
        connexion = new Connexion();
        connexion.toConnect();
    }
    
    
    public Client loadFromDB() {
        ResultSet rs;
        
        try {
            query = "SELECT * FROM Client WHERE cliId = 1;";
            stmt = connexion.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            rs = stmt.executeQuery(query);
            while(rs.next()) {
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
        }catch(SQLException ex) {
            System.out.println("erreur chargement client / " + ex.getMessage());
        }
        
        return client;
    }
    
    @Override
    public void insert() {
    }
    
    @Override
    public void update() {
    }
    
    @Override
    public void search() {
        
    }
    
   
}
