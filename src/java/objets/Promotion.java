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
public class Promotion { 
    private long proId;
    private String proNom;
    private Date proDateDebut;
    private Date proDateFin;
    private String proDescription;
    private Float proReduction;
    private String proImage;
    private int proStatut;
    private String proChampLibre;

    public Promotion() {
    }

    public Promotion(long proId, String proNom, Date proDateDebut, Date proDateFin, String proDescription, Float proReduction, String proImage, int proStatut, String proChampLibre) {
        this.proId = proId;
        this.proNom = proNom;
        this.proDateDebut = proDateDebut;
        this.proDateFin = proDateFin;
        this.proDescription = proDescription;
        this.proReduction = proReduction;
        this.proImage = proImage;
        this.proStatut = proStatut;
        this.proChampLibre = proChampLibre;
    }

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
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

    public Float getProReduction() {
        return proReduction;
    }

    public void setProReduction(Float proReduction) {
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
    
    
}
