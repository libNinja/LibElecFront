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
public class MotCle {
    private String mocLibelle;

    public MotCle() {
    }

    public MotCle(String mocLibelle) {
        this.mocLibelle = mocLibelle;
    }

    public String getMocLibelle() {
        return mocLibelle;
    }

    public void setMocLibelle(String mocLibelle) {
        this.mocLibelle = mocLibelle;
    }

    @Override
    public String toString() {
        return mocLibelle;
    }
    
    
}
