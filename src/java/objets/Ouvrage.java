/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

/**
 *
 * @author Anis
 */
public class Ouvrage {
    private String ouvNom;

    public Ouvrage() {
    }

    public Ouvrage(String ouvNom) {
        this.ouvNom = ouvNom;
    }

    public String getOuvNom() {
        return ouvNom;
    }

    public void setOuvNom(String ouvNom) {
        this.ouvNom = ouvNom;
    }

    @Override
    public String toString() {
        return ouvNom;
    }
    
    
}
