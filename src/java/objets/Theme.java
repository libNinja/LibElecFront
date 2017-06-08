/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

/**
 *
 * @author cdi205
 */
public class Theme {
    private String theNom;

    public Theme() {
    }

    public Theme(String theNom) {
        this.theNom = theNom;
    }

    public String getTheNom() {
        return theNom;
    }

    public void setTheNom(String theNom) {
        this.theNom = theNom;
    }  

    @Override
    public String toString() {
        return theNom;
    }
    
    
}
