/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author cdi204
 */
public class Evenement implements Serializable{
    private long prodId;
    private String proNom;
    private Date proDateDebut;
    private Date proDateFin;
    private String proDescription;
    private float proReduction;
    private String proImage;
    private int proStatut;
    private String proChampLibre;

    public Evenement() {
    }

    public Evenement(long prodId, String proNom, Date proDateDebut, Date proDateFin, String proDescription, float proReduction, String proImage, int proStatut, String proChampLibre) {
        this.prodId = prodId;
        this.proNom = proNom;
        this.proDateDebut = proDateDebut;
        this.proDateFin = proDateFin;
        this.proDescription = proDescription;
        this.proReduction = proReduction;
        this.proImage = proImage;
        this.proStatut = proStatut;
        this.proChampLibre = proChampLibre;
    }

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProNom() {
        return proNom;
    }

    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public Date getProDateDebut() {
        return proDateDebut;
    }

    public void setProDateDebut(Date proDateDebut) {
        this.proDateDebut = proDateDebut;
    }

    public Date getProDateFin() {
        return proDateFin;
    }

    public void setProDateFin(Date proDateFin) {
        this.proDateFin = proDateFin;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public float getProReduction() {
        return proReduction;
    }

    public void setProReduction(float proReduction) {
        this.proReduction = proReduction;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public int getProStatut() {
        return proStatut;
    }

    public void setProStatut(int proStatut) {
        this.proStatut = proStatut;
    }

    public String getProChampLibre() {
        return proChampLibre;
    }

    public void setProChampLibre(String proChampLibre) {
        this.proChampLibre = proChampLibre;
    }

    @Override
    public String toString() {
        return "Evenement{" + "prodId=" + prodId + ", proNom=" + proNom + ", proDateDebut=" + proDateDebut + ", proDateFin=" + proDateFin + ", proDescription=" + proDescription + ", proReduction=" + proReduction + ", proImage=" + proImage + ", proStatut=" + proStatut + ", proChampLibre=" + proChampLibre + '}';
    }   
    
    
}
