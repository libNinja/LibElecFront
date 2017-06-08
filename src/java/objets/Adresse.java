package objets;


public class Adresse {
    private long adrId;
    private long desId;
    private long cliId;
    private long cli_cliId;
    private int adrNumVoie;
    private String adrNomVoie;
    private String adrNomVoieSuite;
    private String adrCp;
    private String adrVille;
    private String adrPays;
    private int adrStatut;
    
    public Adresse(long cliId) {
        this.cliId = cliId;
    }

    public Adresse(long adrId, long desId, long cliId, long cli_cliId, int adrNumVoie, String adrNomVoie, String adrNomVoieSuite, String adrCp, String adrVille, String adrPays, int adrStatut) {
        this.adrId = adrId;
        this.desId = desId;
        this.cliId = cliId;
        this.cli_cliId = cli_cliId;
        this.adrNumVoie = adrNumVoie;
        this.adrNomVoie = adrNomVoie;
        this.adrNomVoieSuite = adrNomVoieSuite;
        this.adrCp = adrCp;
        this.adrVille = adrVille;
        this.adrPays = adrPays;
        this.adrStatut = adrStatut;
    }

    public long getAdrId() {
        return adrId;
    }

    public void setAdrId(long adrId) {
        this.adrId = adrId;
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

    public long getCli_cliId() {
        return cli_cliId;
    }

    public void setCli_cliId(long cli_cliId) {
        this.cli_cliId = cli_cliId;
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

    public int getAdrStatut() {
        return adrStatut;
    }

    public void setAdrStatut(int adrStatut) {
        this.adrStatut = adrStatut;
    }
    
    
}
