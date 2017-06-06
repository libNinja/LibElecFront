package model;

import beans.Client;
import java.util.ArrayList;
import java.util.HashMap;
import accessDB.ClientDAO;
import javax.naming.NamingException;

public class VerificateurSaisie {
    private Client client;
    private ClientDAO clientDao;
    private HashMap<String, String> infosMembre;
    private ArrayList<String> listeSaisie;
    HashMap<String, String> listeErreurs; 
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
        try {
            clientDao = new ClientDAO();
            
        }catch(NamingException ex) {
            System.err.println("naming exception : " + ex.getMessage());
        }
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
    
       
    public void checkSaisieNouveauMembre(HashMap infosMembre) {
        String chaineSaisie = "";
        this.infosMembre = infosMembre;
                
        listeErreurs = new HashMap();
        
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
                case "numVoie" :verifierNumVoie(k , v);
                break;
                case "codePostal": verifierCodePostal(k, v);
                break;
                default: verifierChaine(k, v);
                break;
            }
        });
        
//        return listeErreurs;
        
    }
    
    //TODO est-ce que le pays insere par client existe, rajout de la verif? a voir
    
    public void verifierCodePostal(Object k, Object v) {
     String chaineCodePostal = (String) v;
     if(chaineCodePostal.isEmpty()) {
         chaineSaisie = " * vide";
         nouveauComplet = false;
     }
     else if(chaineCodePostal.matches("^[0-9]{2,}$")) {
         chaineSaisie = "";
     }
     else {
         chaineSaisie = " * Invalide, code postal incorrect";
     }
     listeErreurs.put( (String) k, chaineSaisie);
    }
    
    
    public void verifierNumVoie(Object k, Object v) {
     String chaineNumVoie = (String) v;
     if(chaineNumVoie.isEmpty()) {
         chaineSaisie = " * vide";
         nouveauComplet = false;
     }
     else if(chaineNumVoie.matches("^[0-9]{2,}$")) {
         chaineSaisie = "";
     }
     else {
         chaineSaisie = " * Invalide, num voie incorrect";
     }
     listeErreurs.put( (String) k, chaineSaisie);
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
            chaineSaisie = " * vide";
            nouveauComplet = false;
        }
        
        if(chainePassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            chaineSaisie = "";
        }
        else {
            chaineSaisie = " * mot de passe invalide, au mois 3 caractères sont requis";
            nouveauComplet = false;
        }
        
        listeErreurs.put((String) k, chaineSaisie);
    }
    
    public void verifierGenre(Object k, Object v) {
        String chaineGenre = (String) v;
        
        System.out.println("genre dans verificateur : " );
        
        if(chaineGenre == null) {
            chaineSaisie = " * choix obligatoire";
            nouveauComplet = false;
        }
        else if(chaineGenre.equals("Mr") || chaineGenre.equals("Mme") ) {
            chaineSaisie = "";
        }
        
        listeErreurs.put((String) k, chaineSaisie);
    }
    
    public void verifierTelephone(Object k, Object v) {
        String chaineTelephone = (String) v;
        
        if(chaineTelephone.isEmpty()) {
            chaineSaisie = " * vide";
            nouveauComplet = false;
            
        }
        else if(chaineTelephone.matches("^0[1-9]([-. ]?[0-9]{2}){4}$")) {
            chaineSaisie = "";
        }
        else {
            chaineSaisie = " * invalide";
            nouveauComplet = false;
        }
        
        listeErreurs.put((String) k, chaineSaisie);
        
    }
    public void verifierEmail(Object k, Object v) {
        String chaineEmail = (String) v;
        if(chaineEmail.isEmpty()) {
            chaineSaisie = " * vide";
            nouveauComplet = false;
        }
        else if(chaineEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            chaineSaisie = "";
        }
        else {
            chaineSaisie = " * email invalide";
            nouveauComplet = false;
        }
        
        listeErreurs.put((String) k, chaineSaisie);
        
    }
    
//    public void verifierDateNaissance(Object k, Object v) {
//        String chaineDateNaissance = (String) v;
//        if(chaineDateNaissance.isEmpty()) {
//            chaineSaisie = "vide";
//            nouveauComplet = false;
//        }
//        else if(chaineDateNaissance.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)")) {
//            
//        }
//        else {
//            chaineSaisie = "invalide";
//            nouveauComplet = false;
//        }
//
//        listeErreurs.put((String) k, chaineSaisie);
//
//    }
    
    public void verifierChaine(Object k, Object v) {
        String chaineValue = (String) v;
        if(chaineValue.isEmpty()) {
            chaineSaisie = " * vide";
            nouveauComplet = false;
        }
        else if(chaineValue.matches("[a-zA-Z]+")) {
            chaineSaisie = "";
        }
        else {
            chaineSaisie = " * invalide";
            nouveauComplet = false;
        }
        
        listeErreurs.put((String) k, chaineSaisie);
        
    }
    
    public boolean getNouveauComplet() {
        return this.nouveauComplet;
    }
    
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public HashMap getListeErreurs() {
        return this.listeErreurs;
    }
    
    
}
