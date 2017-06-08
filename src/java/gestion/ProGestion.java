/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import DB.PromotionDB;
import java.sql.SQLException;
import javax.naming.NamingException;
import objets.Promotion;

/**
 *
 * @author cdi205
 */
public class ProGestion {
    private PromotionDB pd;

    public ProGestion() throws NamingException {
        this.pd = new PromotionDB();
    }
    
    public Promotion findById(long id) throws SQLException{
        return pd.find(id);
    }
}
