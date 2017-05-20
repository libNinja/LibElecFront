package model;

import beans.Client;
import java.util.ArrayList;
import java.util.HashMap;
import modelTablesDB.ClientDAO;

public class VerificateurSaisie {
    private Client client;
    private ClientDAO clientDao;
    private HashMap<String, String> infosMembre;
    private ArrayList<String> listeSaisie;
    HashMap<String, String> listeChaineControlee;
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
    
    public boolean verifierChaineVide(ArrayList<String> listeSaisie) {
        boolean vide = false;
        this.listeSaisie = listeSaisie;
        
        for(String s : listeSaisie) {
            if(s.isEmpty()) {
                vide = true;
            }
        }
        
        return vide;
    }
    
    public String checkSaisieNouveauMembre(HashMap infosMembre) {
        String chaineSaisie = "";
        this.infosMembre = infosMembre;
        
        listeChaineControlee = new HashMap();
        
        infosMembre.forEach( (k, v) -> {
            String s = (String) k;
            
            switch (s) {
                case "dateNaissance": verifierDateNaissance(k, v);
                break;
                case "email": verifierEmail(k, v);
                break;
                case "telF": verifierTelephone(k, v);
                break;
                case "telM": verifierTelephone(k, v);
                break;
                default: verifierChaine(k, v);
                break;
            }
        });
        
        
            
        
            
            
            
            
            
            
            
            
            
            
            
    }
    
    public void verifierTelephone(Object k, Object v) {
        String chaineTelephone = (String) v;
        
        if(chaineTelephone.isEmpty()) {
            chaineSaisie = "vide";
        }
        else if(chaineTelephone.matches("^0[1-9]([-. ]?[0-9]{2}){4}$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    public void verifierEmail(Object k, Object v) {
        String chaineEmail = (String) v;
        if(chaineEmail.isEmpty()) {
            chaineSaisie = "vide";
        }
        else if(chaineEmail.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    public void verifierDateNaissance(Object k, Object v) {
        String chaineDateNaissance = (String) v;
        if(chaineDateNaissance.isEmpty()) {
            chaineSaisie = "vide";
        }
        else if(chaineDateNaissance.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    public void verifierChaine(Object k, Object v) {
        String chaineValue = (String) v;
        if(chaineValue.isEmpty()) {
            chaineSaisie = "vide";
        }
        else if(chaineValue.matches("[a-zA-Z]+")) {
            chaineSaisie="ok";
        }
        else {
            chaineSaisie = "invalide";
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    
    
    
    
    public Client getClient() {
        return this.client;
    }
    
    
}
