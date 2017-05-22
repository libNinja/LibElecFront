 
package beans;


public class desAdresse {
    
    private long desId;
    private long cliId;
    private long cli_cliId;
    private int adrNumVoie;
    private String adrNomVoie;
    private String adrNomVoieSuite;
    private String adrCp;
    private String adrVille;
    private String adrPays;
    private String adrStatut;

    public desAdresse() {
    }

    public desAdresse(long desId, long cliId, int adrNumVoie, String adrNomVoie, String adrNomVoieSuite, String adrCp, String adrVille, String adrPays) {
        this.desId = desId;
        this.cliId = cliId;
        this.adrNumVoie = adrNumVoie;
        this.adrNomVoie = adrNomVoie;
        this.adrNomVoieSuite = adrNomVoieSuite;
        this.adrCp = adrCp;
        this.adrVille = adrVille;
        this.adrPays = adrPays;
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

    public int getAdrNumVoie() {
        return adrNumVoie;
    }

    public void setAdrNumVoie(int adrNumVoie) {
        this.adrNumVoie = adrNumVoie;
    }

    public String getAdrNomVoie() {
        return adrNomVoie;
    }

    public void setAdrNomVoie(String adrNomVoie) {
        this.adrNomVoie = adrNomVoie;
    }

    public String getAdrNomVoieSuite() {
        return adrNomVoieSuite;
    }

    public void setAdrNomVoieSuite(String adrNomVoieSuite) {
        this.adrNomVoieSuite = adrNomVoieSuite;
    }

    public String getAdrCp() {
        return adrCp;
    }

    public void setAdrCp(String adrCp) {
        this.adrCp = adrCp;
    }

    public String getAdrVille() {
        return adrVille;
    }

    public void setAdrVille(String adrVille) {
        this.adrVille = adrVille;
    }

    public String getAdrPays() {
        return adrPays;
    }

    public void setAdrPays(String adrPays) {
        this.adrPays = adrPays;
    }

    @Override
    public String toString() {
        return "Adresse{" + "desId=" + desId + ", cliId=" + cliId + ", adrNumVoie=" + adrNumVoie + ", adrNomVoie=" + adrNomVoie + ", adrNomVoieSuite=" + adrNomVoieSuite + ", adrCp=" + adrCp + ", adrVille=" + adrVille + ", adrPays=" + adrPays + '}';
    }
    
    
    
}
