/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import beans.Tva;

/**
 *
 * @author cdi204
 */
public class TvaDAO implements Serializable {

    private MaConnexion mc;

    public TvaDAO() throws NamingException {
        mc = new MaConnexion();
    }

    private Tva mapperTva(ResultSet rs) throws SQLException {
        float f = Float.valueOf(rs.getString("tvaTaux"));
        Tva t = new Tva(rs.getLong("tvaId"), f);
        return t;
    }

    public List<Tva> selectAllTvas() throws SQLException {
        List<Tva> lt = new ArrayList<>();
        try (Connection cnt = mc.getConnection(); Statement st = cnt.createStatement()) {
            String req = "select tvaId, tvaTaux from tva";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tva t = mapperTva(rs);
                lt.add(t);
            }
        }
        return lt;
    }

    public Tva selectTvaById(String ref) throws SQLException {
        Tva t = null;
        String req = "select tva.tvaId, tvaTaux from tva join livre liv on liv.tvaId = tva.tvaId where isbn = ?";
        System.out.println("req= " + req);
        try (Connection cnt = mc.getConnection(); PreparedStatement st = cnt.prepareStatement(req)) {
            st.setString(1, ref);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                t = mapperTva(rs);
            }
        }
        return t;
    }
}
