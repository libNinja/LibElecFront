package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import beans.LignePanier;
import beans.Livre;


public class GestionPanier implements Serializable{
    private HashMap<String, LignePanier> panier;

    public GestionPanier() {
        panier = new HashMap<>();
    }
    
    public Collection<LignePanier> getPanier(){
        return panier.values();
    }
    
    public int getQuantite(){
        int qte = 0;
        Collection<LignePanier> cl = getPanier();
        for(LignePanier l : cl){
            qte += l.getQte();
        }        
        return qte;
    }
    
    public float getPrixTTCTotal(){
        float p = 0;
        Collection<LignePanier> cl = getPanier();
        for(LignePanier l : cl){
            p+= l.getlivPrixTTC();
        }
        return p;
    }
    
    public float getPrixTotal(){
        float p = 0;
        Collection<LignePanier> cl = getPanier();
        for(LignePanier l : cl){
            p+= l.getlivPrix();
        }
        return p;
    }
    
    public void add(Livre livre)throws NullPointerException{
        if(livre == null){
            throw new NullPointerException("livre null!");
        }
        String ref = livre.getIsbn();
        if(panier.containsKey(ref)){
            LignePanier lg = panier.get(ref);
            int newQte = lg.getQte() +1;
            if(newQte > lg.getLivre().getLivStock()){
                newQte = lg.getLivre().getLivStock();
            }
            lg.setQte(newQte);            
        }else{
            LignePanier lg = new LignePanier(livre);
            panier.put(ref, lg);
        }
    }
    
    public void delete(Livre livre)throws NullPointerException{
        if(livre == null){
            throw new NullPointerException("livre null!");
        }
        String ref = livre.getIsbn();
        if(panier.containsKey(ref)){
            LignePanier lg = panier.get(ref);
            int newQte = lg.getQte() -1;
            if(newQte > lg.getLivre().getLivStock()){
                newQte = lg.getLivre().getLivStock();
            }
            lg.setQte(newQte);            
        }else{
            LignePanier lg = new LignePanier(livre);
            panier.put(ref, lg);
        }
    }
    
    public void clear(Livre livre)throws NullPointerException{
        if(livre == null){
            throw new NullPointerException("livre null!");
        }
        String ref = livre.getIsbn();
        if(panier.containsKey(ref)){
            LignePanier lg = panier.get(ref);
            int newQte = lg.getQte() - lg.getQte();
            if(newQte > lg.getLivre().getLivStock()){
                newQte = lg.getLivre().getLivStock();
            }
            lg.setQte(newQte);            
        }else{
            LignePanier lg = new LignePanier(livre);
            panier.put(ref, lg);
        }
    }
    
}
