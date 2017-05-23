
package model;

import accessDB.ClientDAO;
import beans.Client;
import com.sun.faces.facelets.tag.jstl.core.CatchHandler;
import controller.FrontControleur;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Date;
import javax.naming.NamingException;

public class GestionClient implements Serializable{
    private ClientDAO cli;

    public GestionClient() throws NamingException {
         cli = new ClientDAO(); 
}
/*
  public void insertCliInfo (int cliGenre, String cliNom, String cliPrenom, String cliEmail, String cliMdp, Date cliDateAdhesion, String cliTelF,String cliTelM, int cliStatut,String cliChampLibre) throws IllegalArgumentException, SQLException{
        
        cliNom = cliNom.trim();
        cliPrenom = cliPrenom.trim();
        cliEmail = cliEmail.trim();
        cliMdp = cliMdp.trim();
        cliTelF = cliTelF.trim();
        cliTelM = cliTelM.trim();
        cliChampLibre = cliChampLibre.trim();
          
    }  
*/
    public void insertCliInfo(Client nvCli) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
       cli.insertCliInfo(nvCli);
      
    }
    
}   