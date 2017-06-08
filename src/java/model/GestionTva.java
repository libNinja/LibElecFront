/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import accessDB.TvaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import beans.Tva;

/**
 *
 * @author cdi204
 */
public class GestionTva implements Serializable{
    private TvaDAO td;
    
    public GestionTva() throws NamingException{
        td = new TvaDAO();
    }
    
    public List<Tva> findAllTvas() throws SQLException{
        return td.selectAllTvas();
    }
    
    public Tva findTvaById(String ref) throws IllegalArgumentException, SQLException{
        if(ref == null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("La tva est invalide");
        }
        ref = ref.trim();
        return td.selectTvaById(ref);
    }
    
    
}
