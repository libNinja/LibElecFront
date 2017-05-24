
package objets;


public class Editeur {
    
    private long ediId;
    private String ediNom;
    private String ediTeleF;
    private String ediEmail;
    private int ediStatut;
    private String ediChampLibre;

    
    // ------------contructeurs Editeurs-------------
    
    public Editeur() {
    }

    public Editeur(long ediId, String ediNom, String ediTeleF, String ediEmail, int ediStatut, String ediChampLibre) {
        this.ediId = ediId;
        this.ediNom = ediNom;
        this.ediTeleF = ediTeleF;
        this.ediEmail = ediEmail;
        this.ediStatut = ediStatut;
        this.ediChampLibre = ediChampLibre;
    }
    
    
    //-----------getter et setter Editeurs--------------

    public long getEdiId() {
        return ediId;
    }

    public void setEdiId(long ediId) {
        this.ediId = ediId;
    }

    public String getEdiNom() {
        return ediNom;
    }

    public void setEdiNom(String ediNom) {
        this.ediNom = ediNom;
    }

    public String getEdiTeleF() {
        return ediTeleF;
    }

    public void setEdiTelF(String ediTeleF) {
        this.ediTeleF = ediTeleF;
    }

    public String getEdiEmail() {
        return ediEmail;
    }

    public void setEdiEmail(String ediEmail) {
        this.ediEmail = ediEmail;
    }

    public int getEdiStatut() {
        return ediStatut;
    }

    public void setEdiStatut(int ediStatut) {
        this.ediStatut = ediStatut;
    }

    public String getEdiChampLibre() {
        return ediChampLibre;
    }

    public void setEdiChampLibre(String ediChampLibre) {
        this.ediChampLibre = ediChampLibre;
    }

    @Override
    public String toString() {
        return ediNom;
    }

    

   
    
    
    
}
