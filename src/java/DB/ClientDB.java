/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DB;

import java.io.Serializable;
import objets.Client;
import objets.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.naming.NamingException;


public class ClientDB implements Serializable{
    
    private Connexion mc;

    public ClientDB() throws NamingException {
        this.mc = new Connexion();
    }
    
    
    
    @Override
    public void insert() {
        try {
            query = "INSERT INTO Client "
                    + "(cliGenre, cliPrenom, cliNom, cliEmail, cliMdp, cliDateAdhesion, cliTelF, cliTelM, cliStatut, cliChampLibre)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            
            pstmt = Connexion.connexion.prepareStatement(query);

            pstmt.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println("sql exception of insertion: " + ex.getMessage());
        }
    }
    
    // TODO Il ne faut oublier le update AdresseDB (attente pour voir sa mise en place)
    @Override
    public void update(long id, String attribut, String nouveauAttribut) {
        try {
            query = "UPDATE Client "
                    + "SET " + attribut +" = '" + nouveauAttribut + "' "
                    + "WHERE cliId = " + id + ";";
            
           
            pstmt = Connexion.connexion.prepareStatement(query);
      pstmt.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println("sql exception of update: " + ex.getMessage());
        }
    }
    
    public Vector loadClientOfDB() {
        Vector listeClients = new Vector();
        ResultSet rs;
        
        try {
            query = "SELECT * FROM Client;";
            stmt = Connexion.connexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
       
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                client = new Client();
                Vector v = new Vector();
                
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
                
                v.add(client.getCliId());
                v.add(client.getCliGenre());
                v.add(client.getCliPrenom());
                v.add(client.getCliNom());
                v.add(client.getCliEmail());
                v.add(client.getCliMdp());
                v.add(client.getCliDateAdhesion());
                v.add(client.getCliTelF());
                v.add(client.getCliTelM());
                v.add(client.getCliStatut());
                v.add(client.getCliChampLibre());
                
                System.out.println("client :" + client);
                              
                listeClients.add(v);
            }
        }catch (SQLException ex) {
            System.out.println(" erreur chargement client" + ex.getMessage());
        }
        
        return listeClients;
    }
    
    public Vector searchClient(String nom) {
        ResultSet rs;
        Vector vectorNom = new Vector();
        Vector listeVectorNom = new Vector();
         try {
            query = "SELECT * FROM Client "
                    + "WHERE cliNom = '"
                    + nom + "';";
            
            stmt = Connexion.connexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
       
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
                
                vectorNom.add(client.getCliId());
                vectorNom.add(client.getCliGenre());
                vectorNom.add(client.getCliPrenom());
                vectorNom.add(client.getCliNom());
                vectorNom.add(client.getCliEmail());
                vectorNom.add(client.getCliMdp());
                vectorNom.add(client.getCliDateAdhesion());
                vectorNom.add(client.getCliTelF());
                vectorNom.add(client.getCliTelM());
                vectorNom.add(client.getCliStatut());
                vectorNom.add(client.getCliChampLibre());
                     
                listeVectorNom.add(vectorNom);
            }
        }catch (SQLException ex) {
            System.out.println(" erreur chargement client" + ex.getMessage());
        }
         
         return listeVectorNom;
    }
    
    
     public Vector searchClient(long id) {
        ResultSet rs;
        Vector vectorId = new Vector();
        Vector listeVectorId = new Vector();
         try {
            query = "SELECT * FROM Client "
                    + "WHERE cliId = '"
                    + id + "';";
             System.out.println("query: " + query);
            stmt = Connexion.connexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
       
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
                
                vectorId.add(client.getCliId());
                vectorId.add(client.getCliGenre());
                vectorId.add(client.getCliPrenom());
                vectorId.add(client.getCliNom());
                vectorId.add(client.getCliEmail());
                vectorId.add(client.getCliMdp());
                vectorId.add(client.getCliDateAdhesion());
                vectorId.add(client.getCliTelF());
                vectorId.add(client.getCliTelM());
                vectorId.add(client.getCliStatut());
                vectorId.add(client.getCliChampLibre());
                     
                listeVectorId.add(vectorId);
               
            }
        }catch (SQLException ex) {
            System.out.println(" erreur chargement client" + ex.getMessage());
        }
         
         return listeVectorId;
    }
        
}
