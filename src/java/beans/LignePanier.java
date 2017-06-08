/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import model.Promotion;

/**
 *
 * @author cdi204
 */
public class LignePanier implements Serializable {

    private Livre livre;
    private int qte;
    private Tva tva;
    private float tvaTaux;
    private float proReduction;

    public LignePanier() {
    }

//    public LignePanier(Livre livre, int qte, Tva tva, float tvaTaux, float proReduction) {
//        this.livre = livre;
//        this.qte = qte;
//        this.tva = tva;
//        this.tvaTaux = tvaTaux;
//        this.proReduction = proReduction;
//    }   
        
    public LignePanier(Livre livre) {
        setLivre(livre);
        qte = 1;
    }

    public Livre getLivre() {
        return livre;
    }

    private void setLivre(Livre livre) {
        if (livre == null) {
            throw new NullPointerException("livre null !");
        }
        this.livre = livre;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        if (qte >= 0) {
        }
        this.qte = qte;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public float getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(float tvaTaux) {
        this.tvaTaux = tvaTaux;
    }

    public float getlivPrix() {
        return qte * livre.getLivPrix();
    }

    public float getlivPrixTTC() {
        return (qte * livre.getLivPrix()) * (1 + tva.getTvaTaux());
    }    

    public float getProReduction() {
        return proReduction;
    }

    public void setProReduction(float proReduction) {
        this.proReduction = proReduction;
    }

    @Override
    public String toString() {
        return "LignePanier{" + "livre=" + livre + ", qte=" + qte + ", tva=" + tva + ", tvaTaux=" + tvaTaux + ", proReduction=" + proReduction + '}';
    }

   

    
}
