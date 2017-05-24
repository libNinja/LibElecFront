/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import DB.ThemeDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import objets.Theme;

/**
 *
 * @author cdi205
 */
public class ThemeGes {

    private ThemeDB ld;
    private List<String> clefs;

    public ThemeGes() throws NamingException {
        this.ld = new ThemeDB();
        clefs = new ArrayList<>();
        clefs.add("A-B");
        clefs.add("C-E");
        clefs.add("F-H");
        clefs.add("I-K");
        clefs.add("L-N");
        clefs.add("O-R");
        clefs.add("S-V");
        clefs.add("W-Z");
    }

    public HashMap<String, List<Theme>> findAllTheme() throws SQLException {
        HashMap<String, List<Theme>> mp = new HashMap<>();
        for (String cle : clefs) {
            mp.put(cle, new ArrayList<>());
        }

        List<Theme> lp = ld.loadAll();
        for (Theme p : lp) {
            String c = p.getTheNom().toUpperCase().charAt(0) + "";
            for (String cl : clefs) {
                if (c.matches("[" + cl + "]")) {
                    mp.get(cl).add(p);
                }
            }
        }
        return mp;
    }

    public Theme findByNom(String nom) throws SQLException {
        nom = nom.trim();
        return ld.find(nom);
    }

    public List<String> getClefs() {
        return clefs;
    }  
}
