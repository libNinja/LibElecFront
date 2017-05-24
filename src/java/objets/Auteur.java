/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

import java.util.Date;

/**
 *
 * @author cdi205
 */
public class Auteur {
    private long autId;
    private String autNom;
    private String autPrenom;
    private Date autDateNaissance;
    private short autGenre; //0 = Monsieur; 1 = Mademoiselle
    private String autBio;

    public Auteur() {
    }

    public Auteur(long autId, String autNom, String autPrenom, Date autDateNaissance, short autGenre, String autBio) {
        this.autId = autId;
        this.autNom = autNom;
        this.autPrenom = autPrenom;
        this.autDateNaissance = autDateNaissance;
        this.autGenre = autGenre;
        this.autBio = autBio;
    }

    public long getAutId() {
        return autId;
    }

    public void setAutId(long autId) {
        this.autId = autId;
    }

    public String getAutNom() {
        return autNom;
    }

    public void setAutNom(String autNom) {
        this.autNom = autNom;
    }

    public String getAutPrenom() {
        return autPrenom;
    }

    public void setAutPrenom(String autPrenom) {
        this.autPrenom = autPrenom;
    }

    public Date getAutDateNaissance() {
        return autDateNaissance;
    }

    public void setAutDateNaissance(Date autDateNaissance) {
        this.autDateNaissance = autDateNaissance;
    }

    public short getAutGenre() {
        return autGenre;
    }

    public void setAutGenre(short autGenre) {
        this.autGenre = autGenre;
    }

    public String getAutBio() {
        return autBio;
    }

    public void setAutBio(String autBio) {
        this.autBio = autBio;
    }

    @Override
    public String toString() {
        return autNom + " " + autPrenom;
    }
    
    
}
