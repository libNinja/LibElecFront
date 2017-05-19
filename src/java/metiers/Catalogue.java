/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metiers;

import accesBDD.CatalogueDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.Livre;

/**
 *
 * @author cdi204
 */
public class Catalogue implements Serializable{
    private CatalogueDAO cd;

    public Catalogue() throws NamingException{
        cd = new CatalogueDAO();
    }
    
    public List<Livre> findAllLivres() throws SQLException{
        return cd.selectAllLivres();
    }
    
    public Livre findLivreById(String ref) throws IllegalArgumentException, SQLException{
        if(ref == null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("L'isbn est invalide");
        }
        ref = ref.trim();
        return cd.selectLivreById(ref);
    }
}
