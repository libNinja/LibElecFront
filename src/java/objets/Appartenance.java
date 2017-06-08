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
public class Appartenance {
    private  String ouvNom;
    private String souNom;

    public Appartenance() {
    }

    public Appartenance(String ouvNom, String souNom) {
        this.ouvNom = ouvNom;
        this.souNom = souNom;
    }
    

    public String getOuvNom() {
        return ouvNom;
    }

    public void setOuvNom(String ouvNom) {
        this.ouvNom = ouvNom;
    }

    public String getSouNom() {
        return souNom;
    }

    public void setSouNom(String souNom) {
        this.souNom = souNom;
    }
    
    
}
