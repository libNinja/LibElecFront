package model;

import accessDB.ClientDAO;
import accessDB.AdresseDAO;
import beans.Client;
import beans.Adresse;
import javax.naming.NamingException;

public class GestionClient {
    public ClientDAO clientDao;
    public AdresseDAO adresseDao;
    public Client client;
    public Adresse adresse;
    
    public GestionClient() {
        
    }
    
    public GestionClient(Client client) {
        this.client = client;
        
    }
    
    public GestionClient(Client client, Adresse adresse) {
     this.client = client;
     this.adresse = adresse;
        
    }
    
    public void ajouterNouveauClient() {
        try {
            clientDao = new ClientDAO(client);
            clientDao.insert();
        }catch(NamingException ex) {
            System.err.println("naming exception : " + ex.getMessage());
        }
    }
    
    
    
}
