package model;

import beans.Client;
import java.util.ArrayList;
import java.util.HashMap;
import accessDB.ClientDAO;

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
        nouveauComplet = true;
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
        
        
        listeChaineControlee = new HashMap();
        
        infosMembre.forEach( (k, v) -> {
            String s = (String) k;
            
            switch (s) {
                case "genre": verifierGenre(k, v);
                break;
                case "email": verifierEmail(k, v);
                break;
                case "telF": verifierTelephone(k, v);
                break;
                case "telM": verifierTelephone(k, v);
                break;
                case "password": verifierPassword(k, v);
                break;
                default: verifierChaine(k, v);
                break;
            }
        });
        
        return listeChaineControlee;
        
    }
    
    public void verifierPassword(Object k, Object v) {
        String chainePassword = (String) v;
        
        /**
        
        ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
        
        */
        if(chainePassword.isEmpty()){
            chaineSaisie = "vide";
            nouveauComplet = false;
        }
        
        if(chainePassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "password";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
    }
    
    public void verifierGenre(Object k, Object v) {
        String chaineGenre = (String) v;
        
        System.out.println("genre dans verificateur : " );
        
        if(chaineGenre == null) {
            chaineSaisie = "choix obligatoire";
            nouveauComplet = false;
        }
        else if(chaineGenre.equals("Mr") || chaineGenre.equals("Mme") ) {
            chaineSaisie = "ok";
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
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
        else if(chaineEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            chaineSaisie = "ok";
        }
        else {
            chaineSaisie = "invalide";
            nouveauComplet = false;
        }
        
        listeChaineControlee.put((String) k, chaineSaisie);
        
    }
    
//    public void verifierDateNaissance(Object k, Object v) {
//        String chaineDateNaissance = (String) v;
//        if(chaineDateNaissance.isEmpty()) {
//            chaineSaisie = "vide";
//            nouveauComplet = false;
//        }
//        else if(chaineDateNaissance.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")) {
//            chaineSaisie = "ok";
//        }
//        else {
//            chaineSaisie = "invalide";
//            nouveauComplet = false;
//        }
//
//        listeChaineControlee.put((String) k, chaineSaisie);
//
//    }
    
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
    
    public boolean getNouveauComplet() {
        System.out.println("nouveau dans verificateur : " + nouveauComplet);
        return this.nouveauComplet;
    }
    
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    
    
}
