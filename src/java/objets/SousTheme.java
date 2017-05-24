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
public class SousTheme {
    private String theNom;
    private String souNom;

    public SousTheme() {
    }

    public SousTheme(String theNom, String souNom) {
        this.theNom = theNom;
        this.souNom = souNom;
    }

    public String getTheNom() {
        return theNom;
    }

    public void setTheNom(String theNom) {
        this.theNom = theNom;
    }

    public String getSouNom() {
        return souNom;
    }

    public void setSouNom(String souNom) {
        this.souNom = souNom;
    }

    @Override
    public String toString() {
        return souNom;
    }
    
    
}
