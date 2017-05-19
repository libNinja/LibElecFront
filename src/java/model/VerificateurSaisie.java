package model;

import beans.Client;
import java.util.HashMap;
import modelTablesDB.ClientDAO;

public class VerificateurSaisie {
    private Client client;
    private ClientDAO clientDao;
    private HashMap<String, String> infosMembre;
    private String email;
    private String password;
    private String chaineSaisie;
    
    public VerificateurSaisie() {
        
    }
    
    public VerificateurSaisie(String email) {
        this.email = email;
        
        
    }
    
    public boolean checkClient() {
        boolean check = false;
        clientDao = new ClientDAO();
        
        if(clientDao.isExists(email)) {
            client = clientDao.loadFromDB(email);
            check = true;
        }
        
        return check;
    }
    
    public boolean checkMdp(String mdp) {
        boolean check = false;
        if(client.getCliMdp().equals(mdp)) {
            check = true;
        }
        return check;
    }
    
    public String checkSaisieNouveauMembre(HashMap infosMembre) {
        chaineSaisie = "";
        this.infosMembre = infosMembre;
        
        infosMembre.forEach( (k, v) -> {
            switch (k) {
                case "dateNaissance": verifierDate(v);
                break;
                case "email": verifierEmail(v);
                break;
                case "telF": verifierFixe(v);
                break;
                case "telM": verifierMobile(v);
                break;
                default: verifierChaine(v);
                break;
            }
        });
    }
    
    public void verifierChaine(Object v) {
        String chaineValue = (String) v;
        if(chaineValue.isEmpty()) {
            chaineSaisie = "";
        }
        else if(chaineValue.matches([a-zA-Z]+)) {
        chaineSaisie="ok";
    }
        
    }
    
    
    public void verifierDateNaissance(Object v) {
        String chaine = (String) v;
        
    }
    
    
    
    
    public Client getClient() {
        return this.client;
    }
    
    
}
