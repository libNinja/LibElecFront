/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author cdi204
 */
public class Tva implements Serializable{
    private long tvaId;
    private float tvaTaux;

    public Tva() {
    }

    public Tva(long tvaId, float tvaTaux) {
        this.tvaId = tvaId;
        this.tvaTaux = tvaTaux;
    }

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

    @Override
    public String toString() {
        return "Tva{" + "tvaId=" + tvaId + ", tvaTaux=" + tvaTaux + '}';
    }
    
}
