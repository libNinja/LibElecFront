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
    
    
    public GestionClient() throws NamingException {
        clientDao = new ClientDAO();
        adresseDao = new AdresseDAO();
    }

    public GestionClient(Client client) throws NamingException {
        clientDao = new ClientDAO();
        adresseDao = new AdresseDAO();
        this.client = client;
        
    }
    
    public GestionClient(Client client, Adresse adresse) throws NamingException {
        clientDao = new ClientDAO();
        adresseDao = new AdresseDAO();
        this.client = client;
        this.adresse = adresse;
        
    }
    
    
      
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    
    
  
    
    
    
    public void ajouterNouveauClient(Client client) {
        Client nouveauMembre = client;
        clientDao.insert(nouveauMembre);
    }
    
    public void ajouterAdresseNouveauClient(Adresse adresse) {
        Adresse adresseNouveauMembre = adresse;
        adresseDao.insert(adresseNouveauMembre);
    }
    
    public long getIdDB(Client client) throws NamingException {
        Client clientForId = clientDao.loadFromDB(client.getCliEmail());
        return clientForId.getCliId();
    }
    
    
}
