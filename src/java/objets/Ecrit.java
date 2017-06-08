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
public class Ecrit {
    private long autId;
    private String ouvNom;

    public Ecrit() {
    }

    public Ecrit(long autId, String ouvNom) {
        this.autId = autId;
        this.ouvNom = ouvNom;
    }

    public long getAutId() {
        return autId;
    }

    public void setAutId(long autId) {
        this.autId = autId;
    }

    public String getOuvNom() {
        return ouvNom;
    }

    public void setOuvNom(String ouvNom) {
        this.ouvNom = ouvNom;
    }
    
    
}
