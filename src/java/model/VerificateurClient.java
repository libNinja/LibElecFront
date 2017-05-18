package model;

import beans.Client;
import modelTablesDB.ClientDAO;

public class VerificateurClient {
    private Client client;
    private ClientDAO clientDao;
    private String email;
    private String password;
    
    public VerificateurClient() {
        
    }
    
    public VerificateurClient(String email) {
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
    
    public Client getClient() {
        return this.client;
    }
      
    
}
