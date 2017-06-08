
package beans;

import java.io.Serializable;


public class Destinataire implements Serializable{
    
   private long desId;
   private long ClidId;
   private String desNom;
   private String desPrenom;
   private String desEmail;
   private String desTel;
   private String desStatut;

    public Destinataire() {
    }

    public Destinataire(long desId, long ClidId, String desNom, String desPrenom, String desEmail, String desTel, String desStatut) {
        this.desId = desId;
        this.ClidId = ClidId;
        this.desNom = desNom;
        this.desPrenom = desPrenom;
        this.desEmail = desEmail;
        this.desTel = desTel;
        this.desStatut = desStatut;
    }

    public Destinataire(long ClidId, String desNom, String desPrenom, String desEmail, String desTel, String desStatut) {
        this.ClidId = ClidId;
        this.desNom = desNom;
        this.desPrenom = desPrenom;
        this.desEmail = desEmail;
        this.desTel = desTel;
        this.desStatut = desStatut;
    }

    public long getDesId() {
        return desId;
    }

    public void setDesId(long desId) {
        this.desId = desId;
    }

    public long getClidId() {
        return ClidId;
    }

    public void setClidId(long ClidId) {
        this.ClidId = ClidId;
    }

    public String getDesNom() {
        return desNom;
    }

    public void setDesNom(String desNom) {
        this.desNom = desNom;
    }

    public String getDesPrenom() {
        return desPrenom;
    }

    public void setDesPrenom(String desPrenom) {
        this.desPrenom = desPrenom;
    }

    public String getDesEmail() {
        return desEmail;
    }

    public void setDesEmail(String desEmail) {
        this.desEmail = desEmail;
    }

    public String getDesTel() {
        return desTel;
    }

    public void setDesTel(String desTel) {
        this.desTel = desTel;
    }

    public String getDesStatut() {
        return desStatut;
    }

    public void setDesStatut(String desStatut) {
        this.desStatut = desStatut;
    }

    @Override
    public String toString() {
        return "Destinataire{" + "desId=" + desId + ", ClidId=" + ClidId + ", desNom=" + desNom + ", desPrenom=" + desPrenom + ", desEmail=" + desEmail + ", desTel=" + desTel + ", desStatut=" + desStatut + '}';
    }

     
  
}
