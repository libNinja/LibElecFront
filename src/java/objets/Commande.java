package objets;

import java.time.LocalDate;

public class Commande {
    private long comId;
    private long adrId;
    private long traId;
    private long cliId;
    private long fraId;
    private int staType;
    private long adr_adrId;
    private LocalDate comDate;
    private float DECIMAL;
    private int comModePaiement;
    private String comIp;
    private String comChampLibre;
    private LocalDate comDateExpedition;
    private String comNumeroDeSuivi;
    
    public Commande() {
        
    }

    public Commande(long comId, long adrId, long traId, long cliId, long fraId, int staType, long adr_adrId, LocalDate comDate, float DECIMAL, int comModePaiement, String comIp, String comChampLibre, LocalDate comDateExpedition, String comNumeroDeSuivi) {
        this.comId = comId;
        this.adrId = adrId;
        this.traId = traId;
        this.cliId = cliId;
        this.fraId = fraId;
        this.staType = staType;
        this.adr_adrId = adr_adrId;
        this.comDate = comDate;
        this.DECIMAL = DECIMAL;
        this.comModePaiement = comModePaiement;
        this.comIp = comIp;
        this.comChampLibre = comChampLibre;
        this.comDateExpedition = comDateExpedition;
        this.comNumeroDeSuivi = comNumeroDeSuivi;
    }

    public long getComId() {
        return comId;
    }

    public void setComId(long comId) {
        this.comId = comId;
    }

    public long getAdrId() {
        return adrId;
    }

    public void setAdrId(long adrId) {
        this.adrId = adrId;
    }

    public long getTraId() {
        return traId;
    }

    public void setTraId(long traId) {
        this.traId = traId;
    }

    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    public long getFraId() {
        return fraId;
    }

    public void setFraId(long fraId) {
        this.fraId = fraId;
    }

    public int getStaType() {
        return staType;
    }

    public void setStaType(int staType) {
        this.staType = staType;
    }

    public long getAdr_adrId() {
        return adr_adrId;
    }

    public void setAdr_adrId(long adr_adrId) {
        this.adr_adrId = adr_adrId;
    }

    public LocalDate getComDate() {
        return comDate;
    }

    public void setComDate(LocalDate comDate) {
        this.comDate = comDate;
    }

    public float getDECIMAL() {
        return DECIMAL;
    }

    public void setDECIMAL(float DECIMAL) {
        this.DECIMAL = DECIMAL;
    }

    public int getComModePaiement() {
        return comModePaiement;
    }

    public void setComModePaiement(int comModePaiement) {
        this.comModePaiement = comModePaiement;
    }

    public String getComIp() {
        return comIp;
    }

    public void setComIp(String comIp) {
        this.comIp = comIp;
    }

    public String getComChampLibre() {
        return comChampLibre;
    }

    public void setComChampLibre(String comChampLibre) {
        this.comChampLibre = comChampLibre;
    }

    public LocalDate getComDateExpedition() {
        return comDateExpedition;
    }

    public void setComDateExpedition(LocalDate comDateExpedition) {
        this.comDateExpedition = comDateExpedition;
    }

    public String getComNumeroDeSuivi() {
        return comNumeroDeSuivi;
    }

    public void setComNumeroDeSuivi(String comNumeroDeSuivi) {
        this.comNumeroDeSuivi = comNumeroDeSuivi;
    }
    
    
            
    
}
