
package beans;

import java.util.Date;

public class Client {
    
    private  long cliId;
    private int cliGenre;
    private String cliPrenom;
    private String cliNom;
    private String cliEmail;
    private String cliMdp;
    private Date cliDateAdhesion;
    private String cliTelF;
    private String cliTelM;
    private int cliStatut;
    private String cliChampLibre;

    public Client() {
    }

    public Client(long cliId, int cliGenre, String cliPrenom, String cliNom, String cliEmail, String cliMdp, Date cliDateAdhesion, String cliTelF, String cliTelM, int cliStatut, String cliChampLibre) {
        this.cliId = cliId;
        this.cliGenre = cliGenre;
        this.cliPrenom = cliPrenom;
        this.cliNom = cliNom;
        this.cliEmail = cliEmail;
        this.cliMdp = cliMdp;
        this.cliDateAdhesion = cliDateAdhesion;
        this.cliTelF = cliTelF;
        this.cliTelM = cliTelM;
        this.cliStatut = cliStatut;
        this.cliChampLibre = cliChampLibre;
    }

    public Client(int cliGenre, String cliPrenom, String cliNom, String cliEmail, String cliMdp, Date cliDateAdhesion, String cliTelF, String cliTelM, int cliStatut, String cliChampLibre) {
        this.cliGenre = cliGenre;
        this.cliPrenom = cliPrenom;
        this.cliNom = cliNom;
        this.cliEmail = cliEmail;
        this.cliMdp = cliMdp;
        this.cliDateAdhesion = cliDateAdhesion;
        this.cliTelF = cliTelF;
        this.cliTelM = cliTelM;
        this.cliStatut = cliStatut;
        this.cliChampLibre = cliChampLibre;
    }

    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    public int getCliGenre() {
        return cliGenre;
    }

    public void setCliGenre(int cliGenre) {
        this.cliGenre = cliGenre;
    }

    public String getCliPrenom() {
        return cliPrenom;
    }

    public void setCliPrenom(String cliPrenom) {
        this.cliPrenom = cliPrenom;
    }

    public String getCliNom() {
        return cliNom;
    }

    public void setCliNom(String cliNom) {
        this.cliNom = cliNom;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliMdp() {
        return cliMdp;
    }

    public void setCliMdp(String cliMdp) {
        this.cliMdp = cliMdp;
    }

    public Date getCliDateAdhesion() {
        return cliDateAdhesion;
    }

    public void setCliDateAdhesion(Date cliDateAdhesion) {
        this.cliDateAdhesion = cliDateAdhesion;
    }

    public String getCliTelF() {
        return cliTelF;
    }

    public void setCliTelF(String cliTelF) {
        this.cliTelF = cliTelF;
    }

    public String getCliTelM() {
        return cliTelM;
    }

    public void setCliTelM(String cliTelM) {
        this.cliTelM = cliTelM;
    }

    public int getCliStatut() {
        return cliStatut;
    }

    public void setCliStatut(int cliStatut) {
        this.cliStatut = cliStatut;
    }

    public String getCliChampLibre() {
        return cliChampLibre;
    }

    public void setCliChampLibre(String cliChampLibre) {
        this.cliChampLibre = cliChampLibre;
    }

    @Override
    public String toString() {
        return "Client{" + "cliId=" + cliId + ", cliGenre=" + cliGenre + ", cliPrenom=" + cliPrenom + ", cliNom=" + cliNom + ", cliEmail=" + cliEmail + ", cliMdp=" + cliMdp + ", cliDateAdhesion=" + cliDateAdhesion + ", cliTelF=" + cliTelF + ", cliTelM=" + cliTelM + ", cliStatut=" + cliStatut + ", cliChampLibre=" + cliChampLibre + '}';
    }
    
     
    
}
