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
    
    public VerificateurClient(String email, String password) {
        this.email = email;
        this.password = password;
        
    }
    
    public boolean checkClient() {
        clientDao = new ClientDAO();
        return clientDao.isExists(email);
    }
  
    
}
