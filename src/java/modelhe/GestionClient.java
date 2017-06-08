package modelhe;

import accessDBhe.ClientDAO;
import accessDBhe.AdresseDAO;
import beans.Client;
import beans.Adresse;
import java.time.LocalDate;
import java.util.HashMap;
import javax.naming.NamingException;

public class GestionClient {
    public ClientDAO clientDao;
    public AdresseDAO adresseDao;
    public Client client;
    public Client nouveauMembre;
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
    
    public Client creerNouveauMembre(HashMap<String, String> infosNouveauMembre) {
        HashMap<String, String> infos = infosNouveauMembre;
        nouveauMembre = new Client();
        LocalDate toDay = LocalDate.now();
        
        switch (infos.get("genre")) {
            case "Mr":
                nouveauMembre.setCliGenre(1);
                break;
            case "Mme":
                nouveauMembre.setCliGenre(2);
                break;
        }
        
        nouveauMembre.setCliNom(infos.get("nom"));
        nouveauMembre.setCliPrenom(infos.get("prenom"));
        nouveauMembre.setCliDateAdhesion(toDay.toString());
        nouveauMembre.setCliEmail(infos.get("email"));
        nouveauMembre.setCliMdp(infos.get("password"));
        nouveauMembre.setCliTelF(infos.get("telF"));
        nouveauMembre.setCliTelM(infos.get("telM"));
        
        nouveauMembre.setCliStatut(1);
        
        
        return nouveauMembre;
    }
    
    public Adresse affecterAdresseAuNouveauMembre(long nouveauMembreId, HashMap<String, String> infosNouveau) {
        long cliId = nouveauMembreId;
        HashMap<String, String> infos = infosNouveau;
        Adresse adresseNouveauMembre = new Adresse();
        
        adresseNouveauMembre.setCliId(cliId);
        adresseNouveauMembre.setAdrNumVoie(Integer.valueOf(infos.get("numVoie")));
        adresseNouveauMembre.setAdrNomVoie(infos.get("nomVoie"));
        adresseNouveauMembre.setAdrNomVoieSuite(infos.get("nomVoieSuite"));
        adresseNouveauMembre.setAdrCp(infos.get("codePostal"));
        adresseNouveauMembre.setAdrVille(infos.get("ville"));
        adresseNouveauMembre.setAdrPays(infos.get("pays"));
        
        adresseNouveauMembre.setAdrStatut(1);
        
        return adresseNouveauMembre;
    }
    
    
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }

    public Client getNouveauMembre() {
        return nouveauMembre;
    }

    public void setNouveauMembre(Client nouveauMembre) {
        this.nouveauMembre = nouveauMembre;
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
