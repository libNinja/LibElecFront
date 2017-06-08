package objets;


public class Destinataire {
    private long desId;
    private long cliId;
    private String desNom;
    private String desPrenom;
    private String desEmail;
    private String desTel;
    private int desStatut;
    
    public Destinataire() {
        
    }

    public Destinataire(long desId, long cliId, String desNom, String desPrenom, String desEmail, String desTel, int desStatut) {
        this.desId = desId;
        this.cliId = cliId;
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

    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
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

    public int getDesStatut() {
        return desStatut;
    }

    public void setDesStatut(int desStatut) {
        this.desStatut = desStatut;
    }
    
}
