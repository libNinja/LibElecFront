/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;



public interface DAOInterface {
    
    public void insert();
    
    public void update(long id, String attribut, String nouveauAttribut);
    
       
}
