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
    private boolean nouveauComplet;
    
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
    
    public HashMap checkSaisieNouveauMembre(HashMap infosMembre) {
        String chaineSaisie = "";
        this.infosMembre = infosMembre;
        
        nouveauComplet = true;
        listeChaineControlee = new HashMap();
        
        infosMembre.forEach( (k, v) -> {
            String s = (String) k;
            
            switch (s) {
                case "genre": verifierGenre(k, v);
                break;
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
        
        return listeChaineControlee;
      
    }
    
    public void verifierGenre(Object k, Object v) {
        String chaineGenre = (String) v;
        if(!chaineGenre.equals("M") || !chaineGenre.equals("M)
    
    }
    
    public void verifierTelephone(Object k, Object v) {
        String chaineTelephone = (String) v;
        
        if(chaineTelephone.isEmpty()) {
            chaineSaisie = "vide";
            nouveauComplet = false;
            
        }
        else if(chaineTelephone.matches("^0[1-9]([-. ]?[0-9]{2}){4}$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    public void verifierEmail(Object k, Object v) {
        String chaineEmail = (String) v;
        if(chaineEmail.isEmpty()) {
            chaineSaisie = "vide";
            nouveauComplet = false;
        }
        else if(chaineEmail.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    public void verifierDateNaissance(Object k, Object v) {
        String chaineDateNaissance = (String) v;
        if(chaineDateNaissance.isEmpty()) {
            chaineSaisie = "vide";
            nouveauComplet = false;
        }
        else if(chaineDateNaissance.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    public void verifierChaine(Object k, Object v) {
        String chaineValue = (String) v;
        if(chaineValue.isEmpty()) {
            chaineSaisie = "vide";
            nouveauComplet = false;
        }
        else if(chaineValue.matches("[a-zA-Z]+")) {
            chaineSaisie="ok";
        }
        else {
            chaineSaisie = "invalide";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
    public boolean getFlagNouveauComplet() {
     return this.nouveauComplet;
    }
    
    
    
    public Client getClient() {
        return this.client;
    }
    
    
}
