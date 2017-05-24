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
public class recherche {
    private String mocLibelle;
    private String isbn;

    public recherche() {
    }

    public recherche(String mocLibelle, String isbn) {
        this.mocLibelle = mocLibelle;
        this.isbn = isbn;
    }

    public String getMocLibelle() {
        return mocLibelle;
    }

    public void setMocLibelle(String mocLibelle) {
        this.mocLibelle = mocLibelle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}
