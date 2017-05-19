/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;

/**
 *
 * @author cdi204
 */
public class LignePanier implements Serializable{
    private Livre livre;
    private int qte;

    public LignePanier() {
    }

    public LignePanier(Livre livre) {
        setLivre(livre);
        qte = 1;
    }
    
    public Livre getLivre(){
        return livre;
    }

    private void setLivre(Livre livre) {
        if(livre == null ){
            throw  new NullPointerException("livre null !");
        }
        this.livre = livre;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        if(qte >= 0){            
        }
        this.qte = qte;
    }
    
    public float getlivPrix(){
        return qte * livre.getLivPrix();
    }

    @Override
    public String toString() {
        return "LignePanier{" + "livre=" + livre + ", qte=" + qte + '}';
    }
    
}
