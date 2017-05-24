
package objets;


public class Tva {
    
    private long tvaId;
    private float tvaTaux;
    
    
    // ------------contructeurs Editeurs-------------

    public Tva() {
    }

    public Tva(long tvaId, float tvaTaux) {
        this.tvaId = tvaId;
        this.tvaTaux = tvaTaux;
    }

    public Tva(float tvaTaux) {
        this.tvaTaux = tvaTaux;
    }
    
    //-----------getter et setter Editeurs--------------
    
    public long getTvaId() {
        return tvaId;
    }

    public void setTvaId(long tvaId) {
        this.tvaId = tvaId;
    }

    public float getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(float tvaTaux) {
        this.tvaTaux = tvaTaux;
    }
    
}
