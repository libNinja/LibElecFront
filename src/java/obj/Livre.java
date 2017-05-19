package obj;

import java.io.Serializable;
import java.sql.Date;


public class Livre implements Serializable{
    private String isbn;
    private long ediId;
    private long tvaId;
    private long proId;
    private String ouvNom;
    private int livEdition;
    private Date livDateEdition;
    private String livResume;
    private float livPrix;
    private int livStock;
    private String livImage;
    private String livSousTitre;
    private int livStatut;
    private String livChampLibre;

    public Livre() {
    }

    public Livre(String isbn, long ediId, long tvaId, long proId, String ouvNom, int livEdition, Date livDateEdition, String livResume, float livPrix, int livStock, String livImage, String livSousTitre, int livStatut, String livChampLibre) {
        this.isbn = isbn;
        this.ediId = ediId;
        this.tvaId = tvaId;
        this.proId = proId;
        this.ouvNom = ouvNom;
        this.livEdition = livEdition;
        this.livDateEdition = livDateEdition;
        this.livResume = livResume;
        this.livPrix = livPrix;
        this.livStock = livStock;
        this.livImage = livImage;
        this.livSousTitre = livSousTitre;
        this.livStatut = livStatut;
        this.livChampLibre = livChampLibre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getEdiId() {
        return ediId;
    }

    public void setEdiId(long ediId) {
        this.ediId = ediId;
    }

    public long getTvaId() {
        return tvaId;
    }

    public void setTvaId(long tvaId) {
        this.tvaId = tvaId;
    }

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public String getOuvNom() {
        return ouvNom;
    }

    public void setOuvNom(String ouvNom) {
        this.ouvNom = ouvNom;
    }

    public int getLivEdition() {
        return livEdition;
    }

    public void setLivEdition(int livEdition) {
        this.livEdition = livEdition;
    }

    public Date getLivDateEdition() {
        return livDateEdition;
    }

    public void setLivDateEdition(Date livDateEdition) {
        this.livDateEdition = livDateEdition;
    }

    public String getLivResume() {
        return livResume;
    }

    public void setLivResume(String livResume) {
        this.livResume = livResume;
    }

    public float getLivPrix() {
        return livPrix;
    }

    public void setLivPrix(float livPrix) {
        this.livPrix = livPrix;
    }

    public int getLivStock() {
        return livStock;
    }

    public void setLivStock(int livStock) {
        this.livStock = livStock;
    }

    public String getLivImage() {
        return livImage;
    }

    public void setLivImage(String livImage) {
        this.livImage = livImage;
    }

    public String getLivSousTitre() {
        return livSousTitre;
    }

    public void setLivSousTitre(String livSousTitre) {
        this.livSousTitre = livSousTitre;
    }

    public int getLivStatut() {
        return livStatut;
    }

    public void setLivStatut(int livStatut) {
        this.livStatut = livStatut;
    }

    public String getLivChampLibre() {
        return livChampLibre;
    }

    public void setLivChampLibre(String livChampLibre) {
        this.livChampLibre = livChampLibre;
    }

    @Override
    public String toString() {
        return "Livre{" + "isbn=" + isbn + ", ediId=" + ediId + ", tvaId=" + tvaId + ", proId=" + proId + ", ouvNom=" + ouvNom + ", livEdition=" + livEdition + ", livDateEdition=" + livDateEdition + ", livResume=" + livResume + ", livPrix=" + livPrix + ", livStock=" + livStock + ", livImage=" + livImage + ", livSousTitre=" + livSousTitre + ", livStatut=" + livStatut + ", livChampLibre=" + livChampLibre + '}';
    }  
    
    
}
