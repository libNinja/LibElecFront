/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import accessDB.PromotionDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import beans.Evenement;

/**
 *
 * @author cdi204
 */
public class Promotion implements Serializable{
    private PromotionDAO pd;

    public Promotion() throws NamingException {
        pd = new PromotionDAO();
    }
    
    public List<Evenement> findAllEvenements() throws SQLException{
        return pd.selectAllEvenements();
    }
    
    public Evenement findEvenementByReduction(String ref) throws SQLException{
        if(ref == null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("La reduction est invalide");
        }
        ref = ref.trim();
        return pd.selectEvenementByReduction(ref);
    }       
    
}
