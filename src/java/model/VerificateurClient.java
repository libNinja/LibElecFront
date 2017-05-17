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
        clientDao = new ClientDAO();
        
        return clientDao.isExists(email);
    }
  
    
}
